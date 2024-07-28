package com.oitavarosado.clinica_api.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;

import com.oitavarosado.clinica_api.api.dto.paciente.InsertPacienteDTO;
import com.oitavarosado.clinica_api.domain.entity.Paciente;
import com.oitavarosado.clinica_api.domain.entity.Sexo;
import com.oitavarosado.clinica_api.domain.entity.Uf;
import com.oitavarosado.clinica_api.domain.repository.PacienteRepository;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
class PacienteRepositoryTest{
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	@DisplayName("Paciente encontrado com sucesso no banco de dados")
	void findPacienteByNameCase1() {
		
		Paciente data = new Paciente("teste", Sexo.MASCULINO, LocalDate.of(2003, 04, 14), "teste", "teste", "teste", "teste", "teste", "teste", Uf.RN, "teest", "teste", "teste", "tetes");
		this.createPaciente(data);
	
		Optional<Paciente> foundPaciente = this.pacienteRepository.findById(null)
	}
	
	private Paciente createPaciente(Paciente data) {
		Paciente newPaciente = new Paciente(data);
		this.entityManager.persist(newPaciente);
		return newPaciente;
	}
}
