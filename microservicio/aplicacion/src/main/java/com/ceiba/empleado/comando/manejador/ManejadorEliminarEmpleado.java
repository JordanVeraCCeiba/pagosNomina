package com.ceiba.empleado.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.empleado.servicio.ServicioEliminarEmpleado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEmpleado implements ManejadorComando<Long> {

    private final ServicioEliminarEmpleado servicioEliminarEmpleado;

    public ManejadorEliminarEmpleado(ServicioEliminarEmpleado servicioEliminarEmpleado) {
        this.servicioEliminarEmpleado = servicioEliminarEmpleado;
    }

    public void ejecutar(Long idEmpleado) {
        this.servicioEliminarEmpleado.ejecutar(idEmpleado);
    }
}
