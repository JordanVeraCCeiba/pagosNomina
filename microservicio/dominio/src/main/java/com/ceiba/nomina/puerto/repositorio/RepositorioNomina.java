package com.ceiba.nomina.puerto.repositorio;

import com.ceiba.nomina.modelo.entidad.Nomina;

public interface RepositorioNomina {

    /**
     * Permite crear un nomina
     * @param nomina
     * @return el id generado
     */
    Long crear(Nomina nomina);

    /**
     * Validar el salrio del empleado a pagar
     * @param nomina, pagoEmpleado
     * @return si existe o no
     */
    boolean validarSalario(Nomina nomina);

}
