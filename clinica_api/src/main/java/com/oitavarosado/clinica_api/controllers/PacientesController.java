package com.oitavarosado.clinica_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.paciente.InsertPacienteDTO;
import com.oitavarosado.clinica_api.paciente.Paciente;
import com.oitavarosado.clinica_api.paciente.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	public void cadastrarPaciente(@RequestBody InsertPacienteDTO dados) {
		repository.save(new Paciente(dados));
	}
}
