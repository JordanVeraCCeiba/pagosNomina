package com.ceiba.empleado.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.fabrica.FabricaEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.servicio.ServicioActualizarEmpleado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEmpleado implements ManejadorComando<ComandoEmpleado> {

    private FabricaEmpleado fabricaEmpleado;
    private final ServicioActualizarEmpleado servicioActualizarEmpleado;

    public ManejadorActualizarEmpleado(FabricaEmpleado fabricaEmpleado, ServicioActualizarEmpleado servicioActualizarEmpleado) {
        this.fabricaEmpleado = fabricaEmpleado;
        this.servicioActualizarEmpleado = servicioActualizarEmpleado;
    }

    @Override
    public void ejecutar(ComandoEmpleado comandoEmpleado) {
        Empleado empleado = this.fabricaEmpleado.crear(comandoEmpleado);
        this.servicioActualizarEmpleado.ejecutar(empleado);
    }

}
