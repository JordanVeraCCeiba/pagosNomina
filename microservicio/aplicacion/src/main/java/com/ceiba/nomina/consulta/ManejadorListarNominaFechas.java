package com.ceiba.nomina.consulta;

import com.ceiba.nomina.modelo.dto.DtoNomina;
import com.ceiba.nomina.puerto.dao.DaoNomina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarNominaFechas {

    private final DaoNomina daoNomina;

    public ManejadorListarNominaFechas(DaoNomina daoNomina){
        this.daoNomina = daoNomina;
    }

    public List<DtoNomina> ejecutar(String fecha1, String fecha2){
        return this.daoNomina.listarEntreFechas(fecha1, fecha2);
    }
}
