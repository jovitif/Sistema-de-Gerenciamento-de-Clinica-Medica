package com.oitavarosado.clinica_api.api.RestController;

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

import com.oitavarosado.clinica_api.api.dto.medico.DadosListagemMedico;
import com.oitavarosado.clinica_api.api.dto.medico.InsertMedicoDTO;
import com.oitavarosado.clinica_api.domain.entity.Medico;
import com.oitavarosado.clinica_api.domain.repository.MedicoRepository;
import com.oitavarosado.clinica_api.domain.service.MedicoService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	@Autowired
	private MedicoRepository repository;

	@Autowired
	private MedicoService service;
	
	@GetMapping
	public List<DadosListagemMedico> listar() {
	    List<Medico> medicos = service.getAll(); 
	    return medicos.stream()
	                    .map(DadosListagemMedico::new) 
	                    .toList(); 
	}
	
	@PostMapping
	public ResponseEntity<DadosListagemMedico> cadastrarmedico(@RequestBody @Valid InsertMedicoDTO dados) {
	    Medico medico = service.createmedico(new Medico(dados));
	    
	    DadosListagemMedico criado = new DadosListagemMedico(medico);
	    	    if (criado == null) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    } else {
	        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	    }
	}
	
	@PatchMapping
	public ResponseEntity<DadosListagemMedico> alterarpatch(@Valid @RequestBody InsertMedicoDTO dto) {
	    Medico medico = service.updatemedicoPatch(new Medico(dto));
	    DadosListagemMedico atualizado = new DadosListagemMedico(medico);
	    if(atualizado!=null) {
	    	return new ResponseEntity<>(atualizado, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping
	public ResponseEntity<DadosListagemMedico> alterar(@Valid @RequestBody InsertMedicoDTO dto) {
	    Medico medico = service.updatemedico(new Medico(dto));
	    DadosListagemMedico atualizado = new DadosListagemMedico(medico);
	    if(atualizado!=null) {
	    	return new ResponseEntity<>(atualizado, HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/id/{medicoId}")
	public ResponseEntity<Long> deletar(@PathVariable long medicoId){
		String teste = service.deletemedico(medicoId);
		if(teste.equals("ok")) return new ResponseEntity<>(medicoId, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/uuid/{medicoUuid}")
	public ResponseEntity<UUID> deletar(@PathVariable UUID medicoUuid) {
	String result = service.deletemedico(medicoUuid);
	if (result.equals("ok")) {
	return new ResponseEntity<>(HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	@DeleteMapping("/nome/{medicoNome}")
	public ResponseEntity<String> deletar(@PathVariable String medicoNome) {
	String result = service.deletemedico(medicoNome);
	if (result.equals("ok")) {
	return new ResponseEntity<>(medicoNome, HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
}
