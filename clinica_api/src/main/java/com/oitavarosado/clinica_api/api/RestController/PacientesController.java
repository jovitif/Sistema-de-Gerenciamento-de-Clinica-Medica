package com.oitavarosado.clinica_api.api.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.oitavarosado.clinica_api.domain.service.PacienteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
	@Autowired
	private PacienteRepository repository;

	@Autowired
	private PacienteService service;
	
	@GetMapping
	public List<DadosListagemPaciente> listar() {
	    List<Paciente> pacientes = service.getAll(); 
	    return pacientes.stream()
	                    .map(DadosListagemPaciente::new) 
	                    .toList(); 
	}
	
	@PostMapping
	public ResponseEntity<DadosListagemPaciente> cadastrarPaciente(@RequestBody @Valid InsertPacienteDTO dados) {
	    Paciente paciente = service.createPaciente(new Paciente(dados));
	    
	    DadosListagemPaciente criado = new DadosListagemPaciente(paciente);
	    	    if (criado == null) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    } else {
	        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	    }
	}
	
	@PatchMapping
	public ResponseEntity<DadosListagemPaciente> alterar(@Valid @RequestBody InsertPacienteDTO dto) {
	    Paciente paciente = service.updatepacientePatch(new Paciente(dto));
	    DadosListagemPaciente atualizado = new DadosListagemPaciente(paciente);
	    if(atualizado!=null) {
	    	return new ResponseEntity<>(atualizado, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/id/{pacienteId}")
	public ResponseEntity<Long> deletar(@PathVariable long pacienteId){
		String teste = service.deletePaciente(pacienteId);
		if(teste.equals("ok")) return new ResponseEntity<>(pacienteId, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/uuid/{pacienteUuid}")
	public ResponseEntity<UUID> deletar(@PathVariable UUID pacienteUuid) {
	String result = service.deletePaciente(pacienteUuid);
	if (result.equals("ok")) {
	return new ResponseEntity<>(HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	@DeleteMapping("/nome/{pacienteNome}")
	public ResponseEntity<String> deletar(@PathVariable String pacienteNome) {
	String result = service.deletePaciente(pacienteNome);
	if (result.equals("ok")) {
	return new ResponseEntity<>(pacienteNome, HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	
	
	@PutMapping
	//@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
	//	paciente.atualizarInformacoes(dados);
	}
}
