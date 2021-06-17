package com.ceiba.empleado.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.servicio.testdatabuilder.ComandoEmpleadoTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorEmpleadoTest.class)
public class ComandoControladorEmpleadoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/empleados/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/empleados/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void validacionFechaNacimiento() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setFechaNacimiento("10/10/2021");
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void validacionCedula() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setCedula(123L);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

}
