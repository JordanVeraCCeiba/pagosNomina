package com.ceiba.empleado.servicio;

import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;

public class ServicioEliminarEmpleado {

    private final RepositorioEmpleado repositorioEmpleado;

    public ServicioEliminarEmpleado(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public void ejecutar(Long id) {
        this.repositorioEmpleado.eliminar(id);
    }
}
