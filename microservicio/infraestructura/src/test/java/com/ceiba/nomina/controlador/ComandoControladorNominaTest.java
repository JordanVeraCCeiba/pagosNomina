package com.ceiba.nomina.controlador;

import com.ceiba.ApplicationMock;
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
        nomina.setIdEmpleado(1L);
        nomina.setFechaPago("11/10/2021");
        nomina.setPagoEmpleado(250000D);
        // act - assert
        mocMvc.perform(post("/nomina")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nomina)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void validarPago() throws Exception{
        // arrange
        ComandoNomina nomina = new ComandoNominaTestDataBuilder().build();
        nomina.setIdEmpleado(1L);
        nomina.setPagoEmpleado(1000000D);
        // act - assert
        mocMvc.perform(post("/nomina")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nomina)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionSalario', 'mensaje': 'El salario debe ser igual al registrado o al ultimo actualizado'}"));;
    }

    @Test
    public void validacionDiaDomingo() throws Exception{
        // arrange
        ComandoNomina nomina = new ComandoNominaTestDataBuilder().build();
        nomina.setFechaPago("10/10/2021");
        // act - assert
        mocMvc.perform(post("/nomina")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nomina)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().json("{'nombreExcepcion': 'ExcepcionPagoDomingo', 'mensaje': 'El pago no se puede realizar un domingo'}"));
    }

}
