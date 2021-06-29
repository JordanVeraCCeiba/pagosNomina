package com.ceiba.empleado.servicio.testdatabuilder;
import com.ceiba.empleado.modelo.entidad.Empleado;

public class EmpleadoTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String fechaNacimiento;
    private Double salario;
    private String cargo;

    public EmpleadoTestDataBuilder() {
        nombre = "Jordan";
        apellido = "Vera";
        cedula = 123567L;
        fechaNacimiento = "12/03/1997";
        salario = 2000000D;
        cargo = "Arquitecto Desarrollador";
    }

    public EmpleadoTestDataBuilder conFechaNacimiento(String fecha) {
        this.fechaNacimiento = fecha;
        return this;
    }

    public EmpleadoTestDataBuilder conSalario(Double salario) {
        this.salario = salario;
        return this;
    }

    public EmpleadoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public EmpleadoTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public EmpleadoTestDataBuilder conCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public Empleado build() {
        return new Empleado(id,nombre, apellido,cedula,fechaNacimiento,salario,cargo);
    }

}
