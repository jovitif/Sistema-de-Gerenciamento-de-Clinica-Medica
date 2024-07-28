package com.oitavarosado.clinica_api.paciente;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record DadosListagemPaciente(
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
		this(paciente.getNome(),paciente.getSexo(),paciente.getDataNascimento(),paciente.getCpf(),paciente.getRg(),paciente.getOrgaoEmissor(),paciente.getLogradouro(),paciente.getBairro(),paciente.getCidade(),paciente.getUf(),paciente.getCep(),paciente.getTelefone(),paciente.getEmail(),paciente.getObservacoes());
	}
}
