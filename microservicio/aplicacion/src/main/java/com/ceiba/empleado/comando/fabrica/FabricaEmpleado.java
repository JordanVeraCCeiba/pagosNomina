package com.ceiba.empleado.comando.fabrica;

import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import org.springframework.stereotype.Component;

@Component
public class FabricaEmpleado {

    public Empleado crear(ComandoEmpleado comandoEmpleado) {
        return new Empleado(
                comandoEmpleado.getId(),
                comandoEmpleado.getNombre(),
                comandoEmpleado.getApellido(),
                comandoEmpleado.getCedula(),
                comandoEmpleado.getFechaNacimiento(),
                comandoEmpleado.getSalario(),
                comandoEmpleado.getCargo()
        );
    }

}
