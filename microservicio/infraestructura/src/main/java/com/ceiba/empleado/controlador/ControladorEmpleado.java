package com.ceiba.empleado.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.manejador.ManejadorActualizarEmpleado;
import com.ceiba.empleado.comando.manejador.ManejadorCrearEmpleado;
import com.ceiba.empleado.comando.manejador.ManejadorEliminarEmpleado;
import com.ceiba.empleado.consulta.ManejadorConsultarEmpleado;
import com.ceiba.empleado.consulta.ManejadorListarEmpleado;
import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.ceiba.empleado.modelo.entidad.Empleado;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@Api(tags={"Controlador consulta empleado"})
public class ControladorEmpleado {

    private final ManejadorListarEmpleado manejadorListarEmpleado;
    private final ManejadorConsultarEmpleado manejadorConsultarEmpleado;
    private final ManejadorCrearEmpleado manejadorCrearEmpleado;
    private final ManejadorEliminarEmpleado manejadorEliminarEmpleado;
    private final ManejadorActualizarEmpleado manejadorActualizarEmpleado;

    public ControladorEmpleado(ManejadorListarEmpleado manejadorListarEmpleado, ManejadorConsultarEmpleado manejadorConsultarEmpleado, ManejadorCrearEmpleado manejadorCrearEmpleado, ManejadorEliminarEmpleado manejadorEliminarEmpleado, ManejadorActualizarEmpleado manejadorActualizarEmpleado) {
        this.manejadorListarEmpleado = manejadorListarEmpleado;
        this.manejadorConsultarEmpleado = manejadorConsultarEmpleado;
        this.manejadorCrearEmpleado = manejadorCrearEmpleado;
        this.manejadorEliminarEmpleado = manejadorEliminarEmpleado;
        this.manejadorActualizarEmpleado = manejadorActualizarEmpleado;
    }

    @GetMapping
    @ApiOperation("Listar Empleado")
    public List<DtoEmpleado> listar() {
        return this.manejadorListarEmpleado.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Empleado")
    public List<DtoEmpleado> consultarEmpleado(@PathVariable Long id) {
        return this.manejadorConsultarEmpleado.ejecutar(id);
    }

    @PostMapping
    @ApiOperation("Crear Empleado")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEmpleado comandoEmpleado) {
        return manejadorCrearEmpleado.ejecutar(comandoEmpleado);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Empleado")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarEmpleado.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Empleado")
    public void actualizar(@RequestBody ComandoEmpleado comandoEmpleado, @PathVariable Long id) {
        comandoEmpleado.setId(id);
        manejadorActualizarEmpleado.ejecutar(comandoEmpleado);
    }

}
