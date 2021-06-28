package com.ceiba.empleado.consulta;

import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import com.ceiba.empleado.puerto.dao.DaoEmpleado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarEmpleado {

    private final DaoEmpleado daoEmpleado;

    public ManejadorConsultarEmpleado(DaoEmpleado daoEmpleado){
        this.daoEmpleado = daoEmpleado;
    }

    public List<DtoEmpleado> ejecutar(Long id){ return this.daoEmpleado.consult(id); }
}
