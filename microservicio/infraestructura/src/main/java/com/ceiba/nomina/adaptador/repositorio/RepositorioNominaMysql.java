package com.ceiba.nomina.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioNominaMysql implements RepositorioNomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="nomina", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="nomina", value="validarSalario")
    private static String sqlValidarSalario;

    public RepositorioNominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Nomina nomina) {
        return this.customNamedParameterJdbcTemplate.crear(nomina, sqlCrear);
    }

    @Override
    public boolean validarSalario(Nomina nomina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEmpleado", nomina.getIdEmpleado());
        paramSource.addValue("pagoEmpleado", (nomina.getPagoEmpleado()+nomina.getPension()+nomina.getSalud()));
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlValidarSalario,paramSource, Boolean.class);
    }


}
