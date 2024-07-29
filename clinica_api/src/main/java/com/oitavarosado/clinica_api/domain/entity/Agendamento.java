package com.oitavarosado.clinica_api.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_agendamentos")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(updatable = false, nullable = false, unique = true)
	private UUID uuid = UUID.randomUUID();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id", nullable = false)
	@NotNull(message = "O médico é obrigatório")
	private Medico medico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id", nullable = false)
	@NotNull(message = "O paciente é obrigatório")
	private Paciente paciente;

	@NotBlank(message = "O motivo da consulta é obrigatório")
	@Column(nullable = false)
	private String motivoConsulta;

	@Future(message = "A data da consulta deve ser uma data futura")
	@NotNull(message = "A data da consulta é obrigatória")
	private LocalDate dataConsulta;

	@NotNull(message = "A hora da consulta é obrigatória")
	private LocalTime horaConsulta;

	@NotBlank(message = "O local da consulta é obrigatório")
	@Column(nullable = false)
	private String localConsulta;

	private String observacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public String getLocalConsulta() {
		return localConsulta;
	}

	public void setLocalConsulta(String localConsulta) {
		this.localConsulta = localConsulta;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Agendamento(UUID uuid, Medico medico, Paciente paciente, String motivoConsulta, LocalDate dataConsulta,
			LocalTime horaConsulta, String localConsulta, String observacoes) {
		this.uuid = uuid;
		this.medico = medico;
		this.paciente = paciente;
		this.motivoConsulta = motivoConsulta;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.localConsulta = localConsulta;
		this.observacoes = observacoes;
	}
}
