package com.oitavarosado.clinica_api.paciente;

import java.time.LocalDate;

import org.hibernate.annotations.Fetch;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record InsertPacienteDTO(
		// obs: @Future é para validar no futuro
		@NotBlank
		String nome, 
		@Enumerated
		Sexo sexo,
		@Past
		LocalDate dataNascimento,
		@NotBlank
		String cpf,
		@NotBlank
		String rg,
		@NotBlank
		String orgaoEmissor,
		@NotBlank
		String logradouro, 
		@NotBlank
		String bairro,
		@NotBlank
		String cidade,
		@Enumerated
		Uf uf,
		@NotBlank
		String cep,
		@NotBlank
		String telefone,
		@NotBlank
		String email,
		String observacoes) {

}
