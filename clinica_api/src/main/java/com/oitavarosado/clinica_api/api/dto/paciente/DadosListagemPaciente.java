package com.oitavarosado.clinica_api.api.dto.paciente;

import java.time.LocalDate;

import com.oitavarosado.clinica_api.domain.entity.Paciente;
import com.oitavarosado.clinica_api.domain.entity.Sexo;
import com.oitavarosado.clinica_api.domain.entity.Uf;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

// Dados que seram mostrados na tela
public record DadosListagemPaciente(
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
		) {
	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getId(),paciente.getNome(),paciente.getSexo(),paciente.getDataNascimento(),paciente.getCpf(),paciente.getRg(),paciente.getOrgaoEmissor(),paciente.getLogradouro(),paciente.getBairro(),paciente.getCidade(),paciente.getUf(),paciente.getCep(),paciente.getTelefone(),paciente.getEmail(),paciente.getObservacoes());
	}
}
