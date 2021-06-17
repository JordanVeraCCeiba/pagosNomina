package com.ceiba.empleado.puerto.dao;

import com.ceiba.empleado.modelo.dto.DtoNomina;

import java.util.List;

public interface DaoNomina {

    /**
     * Permite listar nomina
     * @return los pagos en nomina
     */
    List<DtoNomina> listar();

}
