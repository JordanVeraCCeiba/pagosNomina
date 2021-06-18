package com.ceiba.empleado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionEdad;
import com.ceiba.dominio.excepcion.ExcepcionError;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.testdatabuilder.EmpleadoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServiciosEmpleadoTest {

    @Test
    public void validarExiste() {
        // arrange
        Empleado empleado = new EmpleadoTestDataBuilder().build();
        RepositorioEmpleado repositorioEmpleado = Mockito.mock(RepositorioEmpleado.class);
        Mockito.when(repositorioEmpleado.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearEmpleado servicioCrearEmpleado = new ServicioCrearEmpleado(repositorioEmpleado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEmpleado.ejecutar(empleado), ExcepcionDuplicidad.class,"El empleado ya existe en el sistema");
    }

    @Test
    public void validarEdad() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conFechaNacimiento("10/10/2020");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionEdad.class, "El empleado debe tener mas de 18 años");
    }

}
