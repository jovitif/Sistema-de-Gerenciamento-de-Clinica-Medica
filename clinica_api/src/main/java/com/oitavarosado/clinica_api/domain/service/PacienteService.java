package com.oitavarosado.clinica_api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oitavarosado.clinica_api.domain.entity.Paciente;
import com.oitavarosado.clinica_api.domain.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List<Paciente> getAll() {
		List<Paciente> pacientes = pacienteRepository.findAll();
		System.out.println(pacientes);
		return pacientes;
	}
	
	public Paciente getByUuid(UUID uuid) {
		Paciente paciente = pacienteRepository.findByUuid(uuid);
		return paciente;
	}
	
	public Paciente getById(long id) {
		Paciente paciente = pacienteRepository.findById(id);
		return paciente;
	}
	
	public Paciente getByNome(String nome) {
		Paciente paciente = pacienteRepository.findByNome(nome);
		return paciente;
	}
	
	public Paciente getByCpf(String cpf) {
		Paciente paciente = pacienteRepository.findByCpf(cpf);
		return paciente;
	}
	
	
	public Paciente createPaciente(Paciente paciente) {
		paciente.setUuid(UUID.randomUUID());
		pacienteRepository.save(paciente);
		return paciente;
	}
	
	public Paciente updatepaciente(Paciente paciente) {
		Paciente pacienteData = pacienteRepository.findByUuid(paciente.getUuid());
	    paciente.setId(pacienteData.getId());    
	    return pacienteRepository.save(paciente);
	}

	public Paciente updatepacientePatch(Paciente paciente) {
		Paciente pacienteData = pacienteRepository.findByNome(paciente.getNome());
		paciente.setId(pacienteData.getId());
		paciente.setUuid(pacienteData.getUuid());
		return pacienteRepository.save(paciente);
	}

	public String deletePaciente(UUID uuid) {
		Paciente pacienteDelete = pacienteRepository.findByUuid(uuid);
		if(pacienteDelete == null)return "paciente não encontrado";
		pacienteRepository.delete(pacienteDelete);
		return "ok";
	}
	
	public String deletePaciente(String nome) {
		Paciente pacienteDelete = pacienteRepository.findByNome(nome);
		if(pacienteDelete == null)return "paciente não encontrado";
		pacienteRepository.delete(pacienteDelete);
		return "ok";
	}	
	
	public String deletePaciente(long id) {
		Paciente pacienteDelete = pacienteRepository.findById(id);
		if (pacienteDelete == null) return "paciente não encontrado";
		pacienteRepository.delete(pacienteDelete);
		return "ok";
	}	
}
