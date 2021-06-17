package com.ceiba.empleado.servicio;

import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;

public class ServicioActualizarEmpleado {

    private final RepositorioEmpleado repositorioEmpleado;

    public ServicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public void ejecutar(Empleado empleado) {
        this.repositorioEmpleado.actualizar(empleado);
    }

}
