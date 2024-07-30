package com.oitavarosado.clinica_api.api.dto.medico;

import com.oitavarosado.clinica_api.domain.entity.CategoriaCBO;
import com.oitavarosado.clinica_api.domain.entity.ConselhoMedico;
import com.oitavarosado.clinica_api.domain.entity.Medico;
import com.oitavarosado.clinica_api.domain.entity.Uf;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemMedico(

		String nome,

		ConselhoMedico conselhoMedico,

		Uf ufConselho,

		String numConselho,

		CategoriaCBO classBrasileira,

		String cpf,

		String logradouro,

		String bairro,

		String cidade,

		Uf uf,

		String cep,

		String telefone, String email) {
	public DadosListagemMedico(Medico medico) {
		this(medico.getNome(),medico.getConselhoMedico(), medico.getUfConselho(),medico.getNumConselho(),medico.getClassBrasileira(),medico.getCpf(), medico.getLogradouro(), medico.getBairro(), medico.getCidade(), medico.getUf(),medico.getCep(), medico.getTelefone(),medico.getEmail());
	}
}
