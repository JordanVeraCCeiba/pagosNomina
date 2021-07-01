package com.ceiba.empleado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.*;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.testdatabuilder.EmpleadoTestDataBuilder;
import com.ceiba.nomina.modelo.entidad.Nomina;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

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
    public void validarExistenciaPrevia() {
        // arrange
        Empleado empleado = new EmpleadoTestDataBuilder().build();
        RepositorioEmpleado repositorioEmpleado = Mockito.mock(RepositorioEmpleado.class);
        Mockito.when(repositorioEmpleado.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearEmpleado servicioCrearEmpleado = new ServicioCrearEmpleado(repositorioEmpleado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEmpleado.validarExistenciaPrevia(empleado), ExcepcionDuplicidad.class,"El empleado ya existe en el sistema");
    }

    @Test
    public void validarEdad() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conFechaNacimiento("10/10/2020");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionEdad.class, "El empleado debe tener mas de 18 años");
    }

    @Test
    public void validarTotalSalario() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conSalario(800_000D);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValidarSalario.class, "El salario debe ser mayor o igual a 850000");
    }

    @Test
    public void validarCampoNombre() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, "El campo nombre es obligatorio");
    }

    @Test
    public void validarCampoApellido() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conApellido(null);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, "El campo apellido es obligatorio");
    }

    @Test
    public void validarCampoCedula() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conCedula(null);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, "El campo cedula es obligatorio");
    }

    @Test
    public void validarCedulaMenor6Digitos() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conCedula(12345L);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionCedula.class, "La cedula debe tener minimo 6 digitos maximo 9");
    }

    @Test
    public void validarCedulaMayor9Digitos() {
        // arrange
        EmpleadoTestDataBuilder usuarioTestDataBuilder = new EmpleadoTestDataBuilder().conCedula(1234567890L);
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionCedula.class, "La cedula debe tener minimo 6 digitos maximo 9");
    }

}
