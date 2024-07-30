package com.oitavarosado.clinica_api.api.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

import com.oitavarosado.clinica_api.domain.entity.Agendamento;
import com.oitavarosado.clinica_api.domain.entity.Medico;
import com.oitavarosado.clinica_api.domain.entity.Paciente;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemAgendamento(Medico medico,

		Paciente paciente,

		String motivoConsulta,

		LocalDate dataConsulta,

		LocalTime horaConsulta,

		String localConsulta,

		String observacoes) {
	public DadosListagemAgendamento(Agendamento agendamento) {
		this(agendamento.getMedico(), agendamento.getPaciente(), agendamento.getMotivoConsulta(),
				agendamento.getDataConsulta(), agendamento.getHoraConsulta(), agendamento.getLocalConsulta(),
				agendamento.getObservacoes());
	}

}
