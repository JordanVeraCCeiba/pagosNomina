package com.ceiba.nomina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.nomina.modelo.dto.DtoNomina;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoNomina implements RowMapper<DtoNomina>, MapperResult {

    @Override
    public DtoNomina mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idEmpleado = resultSet.getLong("idEmpleado");
        String fechaPago = resultSet.getString("fechaPago");
        Double pagoEmpleado = resultSet.getDouble("pagoEmpleado");
        Double salud = resultSet.getDouble("salud");
        Double pension = resultSet.getDouble("pension");

        return new DtoNomina(id,idEmpleado,fechaPago, pagoEmpleado, salud, pension);
    }

}
