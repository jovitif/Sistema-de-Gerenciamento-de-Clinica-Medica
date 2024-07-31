package com.oitavarosado.clinica_api.domain.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.oitavarosado.clinica_api.domain.entity.User;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String gerarToken(User user) {
		try {
		    var algorithm = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer("clinica_api")
		        .withSubject(user.getEmail())
		        .withExpiresAt(dataExpiracao())
		        .sign(algorithm);
		} catch (JWTCreationException exception){
			throw new RuntimeException("Erro ao gerar token",exception);
		}
	}
	
	public String getSubject(String tokenJWT) {
	    if (tokenJWT != null && tokenJWT.startsWith("Bearer ")) {
	        tokenJWT = tokenJWT.substring(7);
	    }

	    try {
	        var algorithm = Algorithm.HMAC256(secret);
	        return JWT.require(algorithm)
	            .withIssuer("clinica_api")
	            .build()
	            .verify(tokenJWT)
	            .getSubject();
	    } catch (JWTVerificationException exception) {
	        throw new RuntimeException("Token inválido ou expirado!", exception);
	    }
	}

	
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
