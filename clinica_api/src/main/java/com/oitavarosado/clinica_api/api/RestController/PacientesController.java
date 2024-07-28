package com.oitavarosado.clinica_api.api.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.api.dto.paciente.DadosAtualizarPaciente;
import com.oitavarosado.clinica_api.api.dto.paciente.DadosListagemPaciente;
import com.oitavarosado.clinica_api.api.dto.paciente.InsertPacienteDTO;
import com.oitavarosado.clinica_api.domain.entity.Paciente;
import com.oitavarosado.clinica_api.domain.repository.PacienteRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	//@Transactional //faz o rollback
	public void cadastrarPaciente(@RequestBody @Valid InsertPacienteDTO dados) {
		repository.save(new Paciente(dados));
	}
	
	@GetMapping
	public List<DadosListagemPaciente> listar(){
		return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
	}
	
	@PutMapping
	//@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
	//	paciente.atualizarInformacoes(dados);
	}
}
