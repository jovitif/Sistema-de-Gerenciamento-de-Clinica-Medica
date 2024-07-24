package com.oitavarosado.clinica_api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.paciente.InsertPacienteDTO;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
	@PostMapping
	public void cadastrarPaciente(@RequestBody InsertPacienteDTO dados) {
		System.out.println(dados);
	}
}
