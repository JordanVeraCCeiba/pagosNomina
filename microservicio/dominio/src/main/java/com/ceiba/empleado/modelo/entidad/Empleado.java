package com.ceiba.empleado.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
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

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.cargo = cargo;

    }

    public void validarEdad(String fechaNacimiento) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
            if(!calendar.getTime().after(date)){
                throw new ExcepcionDuplicidad(EL_EMPLEADO_DEBE_SER_MAYOR_DE_EDAD);
            }
        } catch (ParseException e) {
            throw new ExcepcionDuplicidad(ERROR_FORMATO_DE_FECHA);
        }
    }

}
