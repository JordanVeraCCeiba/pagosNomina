package com.ceiba.nomina.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoNomina {

    private Long id;
    private Long idEmpleado;
    private String fechaPago;
    private Double pagoEmpleado;
    private Double salud;
    private Double pension;

}
