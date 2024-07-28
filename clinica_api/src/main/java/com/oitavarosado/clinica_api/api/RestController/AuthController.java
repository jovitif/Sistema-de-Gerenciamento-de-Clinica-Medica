package com.oitavarosado.clinica_api.api.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.api.dto.auth.DadosAuth;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {
	
	private AuthenticationManager manager;
	
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuth dados){
		var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
		var autenticacao = manager.authenticate(token);
		return ResponseEntity.ok().build();
	}
}
