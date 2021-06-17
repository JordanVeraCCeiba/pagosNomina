package com.ceiba.nomina.comando.fabrica;

import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.empleado.modelo.entidad.Nomina;
import org.springframework.stereotype.Component;

@Component
public class FabricaNomina {

    public Nomina crear(ComandoNomina comandoNomina) {
        return new Nomina(
                comandoNomina.getId(),
                comandoNomina.getIdEmpleado(),
                comandoNomina.getFechaPago(),
                comandoNomina.getPagoEmpleado(),
                comandoNomina.getSalud(),
                comandoNomina.getPension()
        );
    }

}
