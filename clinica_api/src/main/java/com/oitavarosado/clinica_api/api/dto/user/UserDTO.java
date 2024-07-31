package com.oitavarosado.clinica_api.api.dto.user;

import com.oitavarosado.clinica_api.domain.entity.User;

public record UserDTO(Long id, String nome,String email) {
	public UserDTO(User user) {
		this(user.getId(), user.getNome(), user.getEmail());
	}
}
