package com.ceiba.nomina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.nomina.modelo.dto.DtoNomina;
import com.ceiba.nomina.puerto.dao.DaoNomina;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoNominaMysql implements DaoNomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="nomina", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="nomina", value="listarFechas")
    private static String sqlListarFechas;

    public DaoNominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoNomina> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoNomina());
    }

    @Override
    public List<DtoNomina> listarEntreFechas(String fecha1, String fecha2) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha1", fecha1);
        paramSource.addValue("fecha2", fecha2);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarFechas, paramSource, new MapeoNomina());
    }


}
