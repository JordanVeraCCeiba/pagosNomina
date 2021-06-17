package com.ceiba.empleado.servicio.testdatabuilder;

import com.ceiba.empleado.comando.ComandoEmpleado;

public class ComandoEmpleadoTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String fechaNacimiento;
    private Double salario;
    private String cargo;

    public ComandoEmpleadoTestDataBuilder() {
        nombre = "Jordan";
        apellido = "Vera";
        cedula = 123L;
        fechaNacimiento = "12/03/1997";
        salario = 2000000D;
        cargo = "Arquitecto Desarrollador";
    }

    public ComandoEmpleadoTestDataBuilder conFechaNacimiento(String fecha) {
        this.fechaNacimiento = fecha;
        return this;
    }

    public ComandoEmpleado build() {
        return new ComandoEmpleado(id,nombre, apellido,cedula,fechaNacimiento,salario,cargo);
    }
}
