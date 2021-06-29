package com.ceiba.empleado.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionCedula;
import com.ceiba.dominio.excepcion.ExcepcionEdad;
import com.ceiba.dominio.excepcion.ExcepcionErrorFecha;
import com.ceiba.dominio.excepcion.ExcepcionValidarSalario;
import lombok.Getter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Empleado {

    public static final String EL_NOMBRE_ES_OBLIGATORIO = "El campo nombre es obligatorio";
    public static final String EL_APELLIDO_ES_OBLIGATORIO = "El campo apellido es obligatorio";
    public static final String EL_CEDULA_ES_OBLIGATORIO = "El campo cedula es obligatorio";
    public static final String EL_FECHA_NACIMIENTO_ES_OBLIGATORIO = "El campo fecha de nacimiento es obligatorio";
    public static final String EL_SALARIO_ES_OBLIGATORIO = "El campo salario es obligatorio";
    public static final String EL_CARGO_ES_OBLIGATORIO = "El campo cargo es obligatorio";
    public static final String VALIDAR_SALARIO = "El salario debe ser el registrado o el ultimo actualizado";
    public static final String VALIDAR_TOTAL_SALARIO = "El salario debe ser mayor o igual a 850000";
    public static final String VALIDAR_CEDULA = "La cedula debe tener minimo 6 digitos maximo 9";
    private static final String ERROR_FORMATO_DE_FECHA = "Error en el formato de la fecha";
    private static final String EL_EMPLEADO_DEBE_SER_MAYOR_DE_EDAD = "El empleado debe tener mas de 18 años";

    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String fechaNacimiento;
    private Double salario;
    private String cargo;

    public Empleado(Long id, String nombre, String apellido, Long cedula, String fechaNacimiento, Double salario, String cargo) {

        validarObligatorio(nombre, EL_NOMBRE_ES_OBLIGATORIO);
        validarObligatorio(apellido, EL_APELLIDO_ES_OBLIGATORIO);
        validarObligatorio(cedula, EL_CEDULA_ES_OBLIGATORIO);
        validarObligatorio(fechaNacimiento, EL_FECHA_NACIMIENTO_ES_OBLIGATORIO);
        validarObligatorio(salario, EL_SALARIO_ES_OBLIGATORIO);
        validarObligatorio(cargo, EL_CARGO_ES_OBLIGATORIO);
        validarEdad(fechaNacimiento);
        validarTotalSalario(salario);
        validarCedula(cedula);

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.cargo = cargo;

    }

    public void validarTotalSalario(Double salario){
        if(salario < 850000){
            throw new ExcepcionValidarSalario(VALIDAR_TOTAL_SALARIO);
        }
    }

    public void validarCedula(Long cedula){
        if(cedula < 111111 || cedula > 999999999){
            throw new ExcepcionCedula(VALIDAR_CEDULA);
        }
    }

    public void validarEdad(String fechaNacimiento) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
            if(!calendar.getTime().after(date)){
                throw new ExcepcionEdad(EL_EMPLEADO_DEBE_SER_MAYOR_DE_EDAD);
            }
        } catch (ParseException e) {
            throw new ExcepcionErrorFecha(ERROR_FORMATO_DE_FECHA);
        }
    }

}
