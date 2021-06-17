package com.ceiba.empleado.puerto.repositorio;

import com.ceiba.empleado.modelo.entidad.Empleado;

public interface RepositorioEmpleado {

    /**
     * Permite crear un empleado
     * @param empleado
     * @return el id generado
     */
    Long crear(Empleado empleado);

    /**
     * Permite actualizar un empleado
     * @param empleado
     */
    void actualizar(Empleado empleado);

    /**
     * Permite eliminar un empleado
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un empleado con la cedula
     * @param cedula
     * @return si existe o no
     */
    boolean existe(Long cedula);

}
