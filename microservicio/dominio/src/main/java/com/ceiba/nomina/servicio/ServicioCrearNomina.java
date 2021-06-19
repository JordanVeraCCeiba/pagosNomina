package com.ceiba.nomina.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSalario;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;

public class ServicioCrearNomina {

    private static final String ERROR_SALARIO = "El salario debe ser igual al registrado o al ultimo actualizado";

    private final RepositorioNomina repositorioNomina;

    public ServicioCrearNomina(RepositorioNomina repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public Long ejecta(Nomina nomina) {
        validatorSalary(nomina);
        return this.repositorioNomina.crear(nomina);
    }

    public void validatorSalary(Nomina nomina) {
        if(!this.repositorioNomina.validarSalario(nomina)) {
            throw new ExcepcionSalario(ERROR_SALARIO);
        }
    }

}
