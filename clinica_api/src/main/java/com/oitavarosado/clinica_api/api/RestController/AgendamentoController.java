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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oitavarosado.clinica_api.api.dto.agendamento.DadosListagemAgendamento;
import com.oitavarosado.clinica_api.api.dto.agendamento.InsertAgendamentoDTO;
import com.oitavarosado.clinica_api.domain.entity.Agendamento;

import com.oitavarosado.clinica_api.domain.repository.AgendamentoRepository;
import com.oitavarosado.clinica_api.domain.service.AgendamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
	@Autowired
	private AgendamentoRepository repository;

	@Autowired
	private AgendamentoService service;

	@GetMapping
	public List<DadosListagemAgendamento> listar() {
		List<Agendamento> agendamentos = service.getAll();
		return agendamentos.stream().map(DadosListagemAgendamento::new).toList();
	}

	@PostMapping
	public ResponseEntity<DadosListagemAgendamento> cadastraragendamento(
			@RequestBody @Valid InsertAgendamentoDTO dados) {
		Agendamento agendamento = service.createAgendamento(dados);

		DadosListagemAgendamento criado = new DadosListagemAgendamento(agendamento);
		if (criado == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(criado);
		}
	}

	@PatchMapping
	public ResponseEntity<DadosListagemAgendamento> alterar(@Valid @RequestBody InsertAgendamentoDTO dto) {
		Agendamento agendamento = service.updateAgendamentoPatch(new Agendamento(dto));
		DadosListagemAgendamento atualizado = new DadosListagemAgendamento(agendamento);
		if (atualizado != null) {
			return new ResponseEntity<>(atualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/id/{agendamentoId}")
	public ResponseEntity<Long> deletar(@PathVariable long agendamentoId) {
		String teste = service.deleteAgendamento(agendamentoId);
		if (teste.equals("ok"))
			return new ResponseEntity<>(agendamentoId, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/uuid/{agendamentoUuid}")
	public ResponseEntity<UUID> deletar(@PathVariable UUID agendamentoUuid) {
		String result = service.deleteAgendamento(agendamentoUuid);
		if (result.equals("ok")) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
