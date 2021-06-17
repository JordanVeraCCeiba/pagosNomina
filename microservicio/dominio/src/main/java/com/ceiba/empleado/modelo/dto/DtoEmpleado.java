package com.ceiba.empleado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoEmpleado {

    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String fechaNacimiento;
    private Double salario;
    private String cargo;

}
