package com.ceiba.nomina.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.nomina.comando.ComandoNominaFechas;
import com.ceiba.nomina.comando.manejador.ManejadorCrearNomina;
import com.ceiba.nomina.consulta.ManejadorListarNomina;
import com.ceiba.nomina.modelo.dto.DtoNomina;
import com.ceiba.nomina.consulta.ManejadorListarNominaFechas;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nomina")
@Api(tags={"Controlador nomina"})
public class ControladorNomina {

    private final ManejadorListarNomina manejadorListarNomina;
    private final ManejadorListarNominaFechas manejadorListarNominaFechas;
    private final ManejadorCrearNomina manejadorCrearNomina;

    public ControladorNomina(ManejadorListarNomina manejadorListarNomina, ManejadorListarNominaFechas manejadorListarNominaFechas, ManejadorCrearNomina manejadorCrearNomina) {
        this.manejadorListarNomina = manejadorListarNomina;
        this.manejadorListarNominaFechas = manejadorListarNominaFechas;
        this.manejadorCrearNomina = manejadorCrearNomina;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ApiOperation("Listar Nomina")
    public List<DtoNomina> listar() {
        return this.manejadorListarNomina.ejecutar();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/fechas")
    @ApiOperation("Listar Nomina Entre Fechas")
    public List<DtoNomina> listarNominaFechas(@RequestBody ComandoNominaFechas comandoNominaFechas) {
        return this.manejadorListarNominaFechas.ejecutar(comandoNominaFechas.getFecha1(), comandoNominaFechas.getFecha2());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ApiOperation("Crear Nomina")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoNomina comandoNomina) {
        return manejadorCrearNomina.ejecutar(comandoNomina);
    }

}
