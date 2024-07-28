package com.oitavarosado.clinica_api.api.dto.paciente;

import java.time.LocalDate;

import com.oitavarosado.clinica_api.domain.entity.Sexo;
import com.oitavarosado.clinica_api.domain.entity.Uf;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record DadosAtualizarPaciente (
		@NotNull
		Long id,		
		String nome, 
				Sexo sexo,
				LocalDate dataNascimento,
				String cpf,
				String rg,
				String orgaoEmissor,
				String logradouro, 
				String bairro,
				String cidade,
				Uf uf,
				String cep,
				String telefone,
				String email,
				String observacoes
		)
{

}
