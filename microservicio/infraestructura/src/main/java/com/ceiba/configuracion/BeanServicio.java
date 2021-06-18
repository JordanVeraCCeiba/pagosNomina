package com.ceiba.configuracion;

import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import com.ceiba.empleado.servicio.*;
import com.ceiba.nomina.servicio.ServicioCrearNomina;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearEmpleado servicioCrearEmpleado(RepositorioEmpleado repositorioEmpleado) {
        return new ServicioCrearEmpleado(repositorioEmpleado);
    }

    @Bean
    public ServicioEliminarEmpleado servicioEliminarEmpleado(RepositorioEmpleado repositorioEmpleado) {
        return new ServicioEliminarEmpleado(repositorioEmpleado);
    }

    @Bean
    public ServicioActualizarEmpleado servicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado) {
        return new ServicioActualizarEmpleado(repositorioEmpleado);
    }

    @Bean
    public ServicioCrearNomina servicioCrearNomina(RepositorioNomina repositorioNomina) {
        return new ServicioCrearNomina(repositorioNomina);
    }

}
