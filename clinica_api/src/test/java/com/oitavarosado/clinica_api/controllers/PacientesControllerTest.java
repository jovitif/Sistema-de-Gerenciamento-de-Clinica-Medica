package com.oitavarosado.clinica_api.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oitavarosado.clinica_api.api.dto.paciente.DadosListagemPaciente;
import com.oitavarosado.clinica_api.api.dto.paciente.InsertPacienteDTO;
import com.oitavarosado.clinica_api.domain.entity.Paciente;
import com.oitavarosado.clinica_api.domain.entity.Sexo;
import com.oitavarosado.clinica_api.domain.entity.Uf;

@SpringBootTest
@AutoConfigureMockMvc
public class PacientesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreatePaciente1() throws Exception {
        InsertPacienteDTO pacienteDTO = new InsertPacienteDTO(
            "João Silva",
            Sexo.MASCULINO,
            LocalDate.of(1990, 1, 1),
            "12345678901",
            "1234567",
            "SSP",
            "Rua A",
            "Bairro B",
            "Cidade C",
            Uf.SP,
            "12345678",
            "1234567890",
            "joao@gmail.com",
            "Nenhuma"
        );

        mockMvc.perform(post("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pacienteDTO)))
                .andExpect(status().isOk());
    }

  

       
    @Test
    public void shouldCreatePaciente() throws Exception {
        InsertPacienteDTO pacienteDTO = new InsertPacienteDTO("João Silva", Sexo.MASCULINO, LocalDate.of(1990, 1, 1), "12345678901", "1234567", "SSP", "Rua A", "Bairro B", "Cidade C", Uf.SP, "12345678", "1234567890", "joao@gmail.com", "Nenhuma");

        mockMvc.perform(post("/pacientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pacienteDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldListPacientes() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/pacientes"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        List<DadosListagemPaciente> pacientes = objectMapper.readValue(jsonResponse, List.class);

        assertThat(pacientes).isNotNull();
    }
}
