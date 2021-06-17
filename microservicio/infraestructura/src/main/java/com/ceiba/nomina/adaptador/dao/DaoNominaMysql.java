package com.ceiba.nomina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.empleado.modelo.dto.DtoNomina;
import com.ceiba.empleado.puerto.dao.DaoNomina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoNominaMysql implements DaoNomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="nomina", value="listar")
    private static String sqlListar;

    public DaoNominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoNomina> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoNomina());
    }


}
