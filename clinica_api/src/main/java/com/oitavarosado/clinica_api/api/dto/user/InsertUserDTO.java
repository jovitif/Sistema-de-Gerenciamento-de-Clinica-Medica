package com.oitavarosado.clinica_api.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InsertUserDTO(
		@NotBlank
		String nome,
		@NotBlank
		@Size(min=6, max=30)
		String senha,	
		@NotBlank
		@Email
		String email
		) {

	
}
