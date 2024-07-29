package com.oitavarosado.clinica_api.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oitavarosado.clinica_api.domain.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	Paciente findByUuid(UUID uuid);
	Paciente findById(long id);
	Paciente findByNome(String nome);
	Paciente findByCpf(String cpf);
	Paciente findByRg(String rg);
	Paciente findByEmail(String email);
}
