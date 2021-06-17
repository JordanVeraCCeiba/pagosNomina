package com.ceiba.empleado.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEmpleado {

    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String fechaNacimiento;
    private Double salario;
    private String cargo;

}
