package com.ceiba.empleado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.empleado.modelo.dto.DtoEmpleado;

import com.ceiba.empleado.puerto.dao.DaoEmpleado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEmpleadoMysql implements DaoEmpleado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="empleado", value="listar")
    private static String sqlListar;

    public DaoEmpleadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEmpleado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEmpleado());
    }


}
