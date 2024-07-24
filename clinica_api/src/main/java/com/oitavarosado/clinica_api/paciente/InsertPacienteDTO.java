package com.oitavarosado.clinica_api.paciente;

import java.time.LocalDate;

public record InsertPacienteDTO(String nome, 
		Sexo sexo,
		LocalDate dataNascimento,
		String cpf,
		String rg, 
		String orgaoEmissor,
		String logradouro, 
		String bairro,
		String cidade,
		String uf,
		String cep,
		String telefone,
		String email,
		String observacoes) {

}
