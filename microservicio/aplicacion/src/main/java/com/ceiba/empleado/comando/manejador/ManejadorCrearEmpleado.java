package com.ceiba.empleado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.fabrica.FabricaEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEmpleado implements ManejadorComandoRespuesta<ComandoEmpleado, ComandoRespuesta<Long>> {

    private final FabricaEmpleado fabricaEmpleado;
    private final ServicioCrearEmpleado servicioCrearEmpleado;

    public ManejadorCrearEmpleado(FabricaEmpleado fabricaEmpleado, ServicioCrearEmpleado servicioCrearEmpleado) {
        this.fabricaEmpleado = fabricaEmpleado;
        this.servicioCrearEmpleado = servicioCrearEmpleado;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEmpleado comandoEmpleado) {
        Empleado empleado = this.fabricaEmpleado.crear(comandoEmpleado);
        return new ComandoRespuesta<>(this.servicioCrearEmpleado.ejecutar(empleado));
    }
}
