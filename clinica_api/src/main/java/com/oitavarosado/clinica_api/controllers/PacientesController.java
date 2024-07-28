package com.oitavarosado.clinica_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.paciente.DadosListagemPaciente;
import com.oitavarosado.clinica_api.paciente.InsertPacienteDTO;
import com.oitavarosado.clinica_api.paciente.Paciente;
import com.oitavarosado.clinica_api.paciente.PacienteRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional //faz o rollback
	public void cadastrarPaciente(@RequestBody @Valid InsertPacienteDTO dados) {
		repository.save(new Paciente(dados));
	}
	
	@GetMapping
	public List<DadosListagemPaciente> listar(){
		return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
	}
}
