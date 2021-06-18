package com.ceiba.nomina.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionError;
import com.ceiba.dominio.excepcion.ExcepcionErrorFecha;
import lombok.Getter;
import lombok.Setter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Nomina {

    public static final String ID_EMPLEADO_OBLIGATORIO = "El id del empleado es obligatorio";
    public static final String FECHA_PAGO_OBLIGATORIO = "Fecha de pago es obligatoria";
    public static final String PAGO_EMPLEADO_OBLIGATORIO = "El pago del empleado es obligatorio";
    public static final String VALIDACION_FECHA_PAGO = "La fecha de pago es de lunea a sabado";
    public static final String VALIDACION_PAGO = "El pago debe ser igual al registrado o ultimo actualizado";
    private static final String ERROR_FORMATO_DE_FECHA = "Error en el formato de la fecha";
    private static final String EL_PAGO_NO_SE_PUEDE_REALIZAR_UN_DOMINGO = "El pago no se puede realizar un domingo";
    public static final double PORCENTAJE_DESCUENTO_SALUD = 0.04;
    public static final double PORCENTAJE_DESCUENTO_PENSION = 0.04;

    private Long id;
    private Long idEmpleado;
    private String fechaPago;
    private Double pagoEmpleado;
    private Double salud;
    private Double pension;

    public Nomina(Long id, Long idEmpleado, String fechaPago, Double pagoEmpleado, Double salud, Double pension) {

        validarObligatorio(idEmpleado,ID_EMPLEADO_OBLIGATORIO);
        validarObligatorio(fechaPago,FECHA_PAGO_OBLIGATORIO);
        validarObligatorio(pagoEmpleado,PAGO_EMPLEADO_OBLIGATORIO);

        validarFechaPago(fechaPago);

        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fechaPago = fechaPago;
        this.pagoEmpleado = calcularSueldo(pagoEmpleado);
        this.salud = calcularSalud(pagoEmpleado);
        this.pension = calcularPension(pagoEmpleado);
    }

    private Double calcularSalud(Double pagoEmpleado){
        return  pagoEmpleado * PORCENTAJE_DESCUENTO_SALUD;
    }

    private Double calcularPension(Double pagoEmpleado){
        return  pagoEmpleado * PORCENTAJE_DESCUENTO_PENSION;
    }

    private Double calcularSueldo(Double pagoEmpleado){
        return pagoEmpleado - (pagoEmpleado * (PORCENTAJE_DESCUENTO_SALUD+PORCENTAJE_DESCUENTO_PENSION));
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
            throw new ExcepcionErrorFecha(ERROR_FORMATO_DE_FECHA);
        }
    }

}
