package com.oitavarosado.clinica_api.api.dto.agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

import com.oitavarosado.clinica_api.api.dto.medico.InsertMedicoDTO;
import com.oitavarosado.clinica_api.api.dto.paciente.InsertPacienteDTO;

public record InsertAgendamentoDTO(
		InsertMedicoDTO medico,
		InsertPacienteDTO paciente,
		String motivoConsulta,
		LocalDate dataConsulta,
		LocalTime horaConsulta,
		String localConsulta,
		String observacoes){

}
