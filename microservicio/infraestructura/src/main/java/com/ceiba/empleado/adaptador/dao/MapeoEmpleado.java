package com.ceiba.empleado.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEmpleado implements RowMapper<DtoEmpleado>, MapperResult {

    @Override
    public DtoEmpleado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        Long cedula = resultSet.getLong("cedula");
        String fechaNacimiento = resultSet.getString("fechaNacimiento");
        Double salario = resultSet.getDouble("salario");
        String cargo = resultSet.getString("cargo");

        return new DtoEmpleado(id,nombre,apellido, cedula, fechaNacimiento, salario, cargo);
    }

}
