package com.ceiba.nomina.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.nomina.testdatabuilder.ComandoNominaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorNominaTest.class)
public class ComandoControladorNominaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoNomina nomina = new ComandoNominaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/nomina")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nomina)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }

    @Test
    public void validarPago() throws Exception{
        // arrange
        ComandoNomina nomina = new ComandoNominaTestDataBuilder().build();
        nomina.setPagoEmpleado(1000000D);
        // act - assert
        mocMvc.perform(post("/nomina")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nomina)))
                .andExpect(status().is4xxClientError());
    }

}
