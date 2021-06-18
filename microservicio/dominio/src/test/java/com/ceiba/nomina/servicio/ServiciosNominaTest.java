package com.ceiba.nomina.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionError;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.servicio.testdatabuilder.NominaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServiciosNominaTest {

    @Test
    public void validarPago() {
        // arrange
        Nomina nomina = new NominaTestDataBuilder().build();
        RepositorioNomina repositorioNomina = Mockito.mock(RepositorioNomina.class);
        Mockito.when(repositorioNomina.validarSalario(Mockito.spy(nomina))).thenReturn(true);
        ServicioCrearNomina servicioCrearNomina = new ServicioCrearNomina(repositorioNomina);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearNomina.validarSalario(nomina), ExcepcionError.class,"El salario debe ser igual al registrado o al ultimo actualizado");
    }

    @Test
    public void validarFechaPago() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conFechaPago("20/06/2021");
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionError.class, "El pago no se puede realizar un domingo");
    }

}
