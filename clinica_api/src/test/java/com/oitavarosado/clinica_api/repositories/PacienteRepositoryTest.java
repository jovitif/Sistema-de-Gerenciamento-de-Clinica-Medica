package com.oitavarosado.clinica_api.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;

import com.oitavarosado.clinica_api.paciente.Paciente;

@DataJpaTest
@ActiveProfiles("test")
class PacienteRepositoryTest{
	@Test
	void findPacienteByDocument() {
		
	}
}
