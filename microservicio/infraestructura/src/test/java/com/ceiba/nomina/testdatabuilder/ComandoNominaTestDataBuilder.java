package com.ceiba.nomina.testdatabuilder;

import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.nomina.comando.ComandoNomina;

public class ComandoNominaTestDataBuilder {

    private Long id;
    private Long idEmpleado;
    private String fechaPago;
    private Double pagoEmpleado;
    private Double salud;
    private Double pension;

    public ComandoNominaTestDataBuilder() {
        idEmpleado = 1L;
        fechaPago = "21/06/2021";
        pagoEmpleado = 2000000.0;
    }

    public ComandoNominaTestDataBuilder conFechaPago(String fecha) {
        this.fechaPago = fecha;
        return this;
    }

    public ComandoNomina build() {
        return new ComandoNomina(id,idEmpleado, fechaPago,pagoEmpleado,salud,pension);
    }
}
