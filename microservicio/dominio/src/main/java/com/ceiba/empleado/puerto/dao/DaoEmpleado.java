package com.ceiba.empleado.puerto.dao;

import com.ceiba.empleado.modelo.dto.DtoEmpleado;

import java.util.List;

public interface DaoEmpleado {

    /**
     * Permite listar empleados
     * @return los empleados
     */
    List<DtoEmpleado> listar();
    List<DtoEmpleado> Consultar(Long id);

}
