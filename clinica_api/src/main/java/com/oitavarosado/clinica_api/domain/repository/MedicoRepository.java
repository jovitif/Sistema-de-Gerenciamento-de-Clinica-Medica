package com.oitavarosado.clinica_api.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oitavarosado.clinica_api.domain.entity.Medico;
import com.oitavarosado.clinica_api.domain.entity.Paciente;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
	Medico findById(long id);

	Medico findByUuid(UUID uuid);

	Medico findByNome(String nome);

}
