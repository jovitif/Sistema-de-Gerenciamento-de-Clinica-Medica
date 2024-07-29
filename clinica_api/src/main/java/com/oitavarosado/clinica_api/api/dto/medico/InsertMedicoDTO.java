package com.oitavarosado.clinica_api.api.dto.medico;

import com.oitavarosado.clinica_api.domain.entity.CategoriaCBO;
import com.oitavarosado.clinica_api.domain.entity.ConselhoMedico;
import com.oitavarosado.clinica_api.domain.entity.Uf;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsertMedicoDTO(
		@NotBlank(message = "O nome é obrigatório")
		@Column(nullable = false)
		 String nome,
		
		@NotNull(message = "O conselho medico é obrigatório")
		@Enumerated(EnumType.STRING)
		@Column(nullable = false)
		 ConselhoMedico conselhoMedico,
		
		@NotNull(message = "A UF do conselho é obrigatória")
		@Enumerated(EnumType.STRING)
		@Column(nullable = false)
		 Uf ufConselho,
		
		@NotBlank(message = "O nome é obrigatório")
		@Column(nullable = false)
		 String numConselho,
	
		@NotNull(message = "A Classificação brasileira de ocupações é obrigatória")
		@Enumerated(EnumType.STRING)
		@Column(nullable = false)
		 CategoriaCBO classBrasileira,
		@NotBlank(message = "O CPF é obrigatório")
		@Column(unique = true, nullable = false)
		 String cpf,
		@NotBlank(message = "O logradouro é obrigatório")
		@Column(nullable = false)
		 String logradouro,
		@NotBlank(message = "O bairro é obrigatório")
		@Column(nullable = false)
		 String bairro,
		@NotBlank(message = "A cidade é obrigatória")
		@Column(nullable = false)
		 String cidade,	
		@NotNull(message = "A UF é obrigatória")
		@Enumerated(EnumType.STRING)
		@Column(nullable = false)
		 Uf uf,
		@NotBlank(message = "O CEP é obrigatório")
		@Column(nullable = false)
		 String cep,

		@NotBlank(message = "O telefone é obrigatório")
		@Column(nullable = false)
		 String telefone,

		@Email(message = "O e-mail deve ser válido")
		@NotBlank(message = "O e-mail é obrigatório")
		@Column(nullable = false)
		 String email
		){
}
