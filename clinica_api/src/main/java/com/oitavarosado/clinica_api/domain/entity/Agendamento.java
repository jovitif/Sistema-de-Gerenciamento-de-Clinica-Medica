package com.oitavarosado.clinica_api.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Agendamento")
@Table(name = "tb_agendamentos")
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// Medico medico;
//	Paciente paciente;
	String motivoConsulta;
	LocalDate dataConsulta;
	LocalTime horaConsulta;
	String localConsulta;
	String observacoes;
}
