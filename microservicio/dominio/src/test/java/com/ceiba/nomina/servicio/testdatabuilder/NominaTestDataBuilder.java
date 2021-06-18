package com.ceiba.nomina.servicio.testdatabuilder;
import com.ceiba.nomina.modelo.entidad.Nomina;

public class NominaTestDataBuilder {

    private Long id;
    private Long idEmpleado;
    private String fechaPago;
    private Double pagoEmpleado;
    private Double salud;
    private Double pension;

    public NominaTestDataBuilder() {
        idEmpleado = 1L;
        fechaPago = "26/06/2021";
        pagoEmpleado = 200000D;
        salud = 80000D;
        pension = 80000D;
    }

    public NominaTestDataBuilder conFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
        return this;
    }

    public Nomina build() {
        return new Nomina(id,idEmpleado,fechaPago, pagoEmpleado,salud,pension);
    }

}
