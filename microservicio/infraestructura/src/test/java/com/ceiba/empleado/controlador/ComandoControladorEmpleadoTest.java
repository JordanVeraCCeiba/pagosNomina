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
                .andExpect(status().is2xxSuccessful())
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
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/empleados/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
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
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionError', 'mensaje': 'El empleado debe tener mas de 18 años'}"));
    }

    @Test
    public void validacionCedula() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setCedula(1090506292L);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionDuplicidad', 'mensaje': 'El empleado ya existe en el sistema'}"));
    }

    @Test
    public void validacionCampoNombre() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setNombre(null);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionValorObligatorio', 'mensaje': 'El campo nombre es obligatorio'}"));
    }

    @Test
    public void validacionCampoApellido() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setApellido(null);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionValorObligatorio', 'mensaje': 'El campo apellido es obligatorio'}"));
    }

    @Test
    public void validacionCampoCedula() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setCedula(null);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionValorObligatorio', 'mensaje': 'El campo cedula es obligatorio'}"));
    }

    @Test
    public void validacionCampoFechaNacimiento() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setFechaNacimiento(null);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionValorObligatorio', 'mensaje': 'El campo fecha de nacimiento es obligatorio'}"));
    }

    @Test
    public void validacionCampoSalario() throws Exception{
        // arrange
        ComandoEmpleado empleado = new ComandoEmpleadoTestDataBuilder().build();
        empleado.setSalario(null);
        // act - assert
        mocMvc.perform(post("/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleado)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionValorObligatorio', 'mensaje': 'El campo salario es obligatorio'}"));
    }
}
