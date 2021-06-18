package com.ceiba.nomina.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionError;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class Nomina {

    public static final String VALIDACION_FECHA_PAGO = "La fecha de pago es de lunea a sabado";
    public static final String VALIDACION_PAGO = "El pago debe ser igual al registrado o ultimo actualizado";
    private static final String ERROR_FORMATO_DE_FECHA = "Error en el formato de la fecha";
    private static final String EL_PAGO_NO_SE_PUEDE_REALIZAR_UN_DOMINGO = "El pago no se puede realizar un domingo";

    private Long id;
    private Long idEmpleado;
    private String fechaPago;
    private Double pagoEmpleado;
    private Double salud;
    private Double pension;

    public Nomina(Long id, Long idEmpleado, String fechaPago, Double pagoEmpleado, Double salud, Double pension) {

        validarFechaPago(fechaPago);
        salud = calcularSalud(pagoEmpleado);
        pension = calcularPension(pagoEmpleado);
        pagoEmpleado = calcularSueldo(pagoEmpleado);

        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fechaPago = fechaPago;
        this.pagoEmpleado = pagoEmpleado;
        this.salud = salud;
        this.pension = pension;
    }

    private Double calcularSalud(Double pagoEmpleado){
        return  pagoEmpleado * 0.04;
    }

    private Double calcularPension(Double pagoEmpleado){
        return  pagoEmpleado * 0.04;
    }

    private Double calcularSueldo(Double pagoEmpleado){
        return pagoEmpleado - (pagoEmpleado * 0.08);
    }

    private void validarFechaPago(String fechaPago) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fechaPago);
            Calendar cal = Calendar. getInstance();
            cal.setTime(date);
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                throw new ExcepcionError(EL_PAGO_NO_SE_PUEDE_REALIZAR_UN_DOMINGO);
            }
        } catch (ParseException e) {
            throw new ExcepcionError(ERROR_FORMATO_DE_FECHA);
        }
    }

}
