package com.oitavarosado.clinica_api.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oitavarosado.clinica_api.domain.entity.Medico;
import com.oitavarosado.clinica_api.domain.repository.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	private MedicoRepository medicoRepository;
	
	public List<Medico> getAll() {
		List<Medico> medicos = medicoRepository.findAll();
		System.out.println(medicos);
		return medicos;
	}
	
	public Medico getByUuid(UUID uuid) {
		Medico medico = medicoRepository.findByUuid(uuid);
		return medico;
	}
	
	public Medico getById(long id) {
		Medico medico = medicoRepository.findById(id);
		return medico;
	}
	
	public Medico getByNome(String nome) {
		Medico medico = medicoRepository.findByNome(nome);
		return medico;
	}
	
	public Medico getByCpf(String cpf) {
		Medico medico = medicoRepository.findByCpf(cpf);
		return medico;
	}
	
	
	public Medico createmedico(Medico medico) {
		medico.setUuid(UUID.randomUUID());
		medicoRepository.save(medico);
		return medico;
	}
	
	public Medico updatemedico(Medico medico) {
		Medico medicoData = medicoRepository.findByUuid(medico.getUuid());
	    medico.setId(medicoData.getId());    
	    return medicoRepository.save(medico);
	}

	public Medico updatemedicoPatch(Medico medico) {
		Medico medicoData = medicoRepository.findByNome(medico.getNome());
		medico.setId(medicoData.getId());
		medico.setUuid(medicoData.getUuid());
		return medicoRepository.save(medico);
	}

	public String deletemedico(UUID uuid) {
		Medico medicoDelete = medicoRepository.findByUuid(uuid);
		if(medicoDelete == null)return "medico não encontrado";
		medicoRepository.delete(medicoDelete);
		return "ok";
	}
	
	public String deletemedico(String nome) {
		Medico medicoDelete = medicoRepository.findByNome(nome);
		if(medicoDelete == null)return "medico não encontrado";
		medicoRepository.delete(medicoDelete);
		return "ok";
	}	
	
	public String deletemedico(long id) {
		Medico medicoDelete = medicoRepository.findById(id);
		if (medicoDelete == null) return "medico não encontrado";
		medicoRepository.delete(medicoDelete);
		return "ok";
	}	
}
