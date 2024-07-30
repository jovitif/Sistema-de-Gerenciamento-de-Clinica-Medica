package com.oitavarosado.clinica_api.domain.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oitavarosado.clinica_api.api.dto.agendamento.InsertAgendamentoDTO;
import com.oitavarosado.clinica_api.domain.entity.Agendamento;
import com.oitavarosado.clinica_api.domain.entity.Medico;
import com.oitavarosado.clinica_api.domain.entity.Paciente;
import com.oitavarosado.clinica_api.domain.repository.AgendamentoRepository;
import com.oitavarosado.clinica_api.domain.repository.MedicoRepository;
import com.oitavarosado.clinica_api.domain.repository.PacienteRepository;
import com.oitavarosado.clinica_api.exceptions.ResourceNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository AgendamentoRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Agendamento> getAll() {
		return AgendamentoRepository.findAll();
	}

	public Agendamento getByUuid(UUID uuid) {
		return AgendamentoRepository.findByUuid(uuid).orElse(null);
	}

	public Agendamento getById(long id) {
		return AgendamentoRepository.findById(id).orElse(null);
	}



	public List<Agendamento> getByDataConsulta(LocalDate dataConsulta) {
		return AgendamentoRepository.findByDataConsulta(dataConsulta);
	}

	public List<Agendamento> getByMedicoNome(String nomeMedico) {
		return AgendamentoRepository.findByMedicoNome(nomeMedico);
	}

   

    public Agendamento createAgendamento(InsertAgendamentoDTO dto) {
        Medico medico = medicoRepository.findById(dto.medicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        // Criar o agendamento
        Agendamento agendamento = new Agendamento();
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setMotivoConsulta(dto.motivoConsulta());
        agendamento.setDataConsulta(dto.dataConsulta());
        agendamento.setHoraConsulta(dto.horaConsulta());
        agendamento.setLocalConsulta(dto.localConsulta());
        agendamento.setObservacoes(dto.observacoes());

        if (isDataEHoraDisponivel(dto.dataConsulta(), dto.horaConsulta())) {
            agendamento.setUuid(UUID.randomUUID());
            return AgendamentoRepository.save(agendamento);
        } else {
            throw new ResourceNotFoundException("Já existe um agendamento para este médico na mesma data e hora.");
        }
    }

	public Agendamento updateAgendamento(Agendamento Agendamento) {
		Agendamento AgendamentoData = AgendamentoRepository.findByUuid(Agendamento.getUuid()).orElse(null);
		if (AgendamentoData == null)
			return null;
		Agendamento.setId(AgendamentoData.getId());
		return AgendamentoRepository.save(Agendamento);
	}

	public Agendamento updateAgendamentoPatch(Agendamento Agendamento) {
		Agendamento AgendamentoData = AgendamentoRepository.findByUuid(Agendamento.getUuid()).orElse(null);
		if (AgendamentoData == null)
			return null;
		Agendamento.setId(AgendamentoData.getId());
		Agendamento.setUuid(AgendamentoData.getUuid());
		return AgendamentoRepository.save(Agendamento);
	}

	public String deleteAgendamento(UUID uuid) {
		Agendamento AgendamentoDelete = AgendamentoRepository.findByUuid(uuid).orElse(null);
		if (AgendamentoDelete == null)
			return "Agendamento não encontrado";
		AgendamentoRepository.delete(AgendamentoDelete);
		return "ok";
	}



	public String deleteAgendamento(long id) {
		Agendamento AgendamentoDelete = AgendamentoRepository.findById(id).orElse(null);
		if (AgendamentoDelete == null)
			return "Agendamento não encontrado";
		AgendamentoRepository.delete(AgendamentoDelete);
		return "ok";
	}

	private boolean isDataEHoraDisponivel(LocalDate dataConsulta, LocalTime horaConsulta) {
		List<Agendamento> Agendamentos = AgendamentoRepository.findByDataConsultaAndHoraConsulta(dataConsulta,
				horaConsulta);
		return Agendamentos.isEmpty();
	}
}
