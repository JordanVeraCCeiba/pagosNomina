package com.ceiba.empleado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.empleado.modelo.entidad.Nomina;
import com.ceiba.empleado.puerto.repositorio.RepositorioNomina;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            throw new ExcepcionDuplicidad(ERROR_SALARIO);
        }
    }

}
