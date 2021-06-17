package com.ceiba.nomina.consulta;

import com.ceiba.empleado.modelo.dto.DtoNomina;
import com.ceiba.empleado.puerto.dao.DaoNomina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarNomina {

    private final DaoNomina daoNomina;

    public ManejadorListarNomina(DaoNomina daoNomina){
        this.daoNomina = daoNomina;
    }

    public List<DtoNomina> ejecutar(){ return this.daoNomina.listar(); }
}
