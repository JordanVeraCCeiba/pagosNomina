package com.ceiba.nomina.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.nomina.comando.manejador.ManejadorCrearNomina;
import com.ceiba.nomina.consulta.ManejadorListarNomina;
import com.ceiba.empleado.modelo.dto.DtoNomina;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nomina")
@Api(tags={"Controlador nomina"})
public class ControladorNomina {

    private final ManejadorListarNomina manejadorListarNomina;
    private final ManejadorCrearNomina manejadorCrearNomina;

    public ControladorNomina(ManejadorListarNomina manejadorListarNomina, ManejadorCrearNomina manejadorCrearNomina) {
        this.manejadorListarNomina = manejadorListarNomina;
        this.manejadorCrearNomina = manejadorCrearNomina;
    }

    @GetMapping
    @ApiOperation("Listar Nomina")
    public List<DtoNomina> listar() {
        return this.manejadorListarNomina.ejecutar();
    }

    @PostMapping
    @ApiOperation("Crear Nomina")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoNomina comandoNomina) {
        return manejadorCrearNomina.ejecutar(comandoNomina);
    }

}
