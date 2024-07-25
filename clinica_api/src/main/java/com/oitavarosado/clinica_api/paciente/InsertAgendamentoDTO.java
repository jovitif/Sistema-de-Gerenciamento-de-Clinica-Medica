package com.oitavarosado.clinica_api.paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public record InsertAgendamentoDTO(
		InsertMedicoDTO medico,
		InsertPacienteDTO paciente,
		String motivoConsulta,
		LocalDate dataConsulta,
		LocalTime horaConsulta,
		String localConsulta,
		String observacoes){

}
