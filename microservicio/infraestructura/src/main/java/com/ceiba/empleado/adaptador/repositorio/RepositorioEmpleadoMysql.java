package com.ceiba.empleado.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEmpleadoMysql implements RepositorioEmpleado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="empleado", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="empleado", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="empleado", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="empleado", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="empleado", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioEmpleadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Empleado empleado) {
        return this.customNamedParameterJdbcTemplate.crear(empleado, sqlCrear);
    }

    @Override
    public void actualizar(Empleado empleado) {
        this.customNamedParameterJdbcTemplate.actualizar(empleado, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long cedula) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

}
