package com.oitavarosado.clinica_api.api.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.api.dto.auth.DadosAuth;
import com.oitavarosado.clinica_api.api.dto.auth.DadosTokenJWT;
import com.oitavarosado.clinica_api.domain.entity.User;
import com.oitavarosado.clinica_api.domain.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuth dados){
		var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
		var autenticacao = manager.authenticate(token);
		var tokenJWT = tokenService.gerarToken((User) autenticacao.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
}
