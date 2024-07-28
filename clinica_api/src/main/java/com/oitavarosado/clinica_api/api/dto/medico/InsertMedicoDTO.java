package com.oitavarosado.clinica_api.api.dto.medico;

import com.oitavarosado.clinica_api.domain.entity.Uf;

public record InsertMedicoDTO(
		String nome,
		String conselhoMedico,
		Uf ufConselho,
		int numeroConselho,
		String classificacaoBrasileiraOcupacao,
		String cpf,
		String logradouro,
		String bairro,
		String cidade,
		Uf uf,
		String cep,
		String telefone,
		String email){
}
