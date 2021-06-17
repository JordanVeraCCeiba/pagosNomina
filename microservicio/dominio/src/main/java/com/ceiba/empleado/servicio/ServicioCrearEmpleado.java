package com.ceiba.empleado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServicioCrearEmpleado {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El empleado ya existe en el sistema";

    private final RepositorioEmpleado repositorioEmpleado;

    public ServicioCrearEmpleado(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public Long ejecutar(Empleado empleado) {
        validarExistenciaPrevia(empleado);
        return this.repositorioEmpleado.crear(empleado);
    }

    public void validarExistenciaPrevia(Empleado empleado) {
        boolean existe = this.repositorioEmpleado.existe(empleado.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
