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

    public Long ejecutar(Nomina nomina) {
        validarSalario(nomina);
        return this.repositorioNomina.crear(nomina);
    }

    public void validarSalario(Nomina nomina) {
        boolean valididarSalario = this.repositorioNomina.validarSalario(nomina);
        if(!valididarSalario) {
            throw new ExcepcionSalario(ERROR_SALARIO);
        }
    }

}
