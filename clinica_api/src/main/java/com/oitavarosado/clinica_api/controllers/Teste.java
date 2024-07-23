package com.oitavarosado.clinica_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Teste {
	@GetMapping
	public String test() {
		return "<h1>Mensagem de teste</h1>";
	}
}
