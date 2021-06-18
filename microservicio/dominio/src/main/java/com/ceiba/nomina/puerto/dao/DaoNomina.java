package com.ceiba.nomina.puerto.dao;

import com.ceiba.nomina.modelo.dto.DtoNomina;

import java.util.List;

public interface DaoNomina {

    /**
     * Permite listar nomina
     * @return los pagos en nomina
     */
    List<DtoNomina> listar();

    List<DtoNomina> listarEntreFechas(String fecha1,String fecha2);

}
