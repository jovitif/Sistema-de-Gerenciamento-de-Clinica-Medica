package com.oitavarosado.clinica_api.domain.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oitavarosado.clinica_api.domain.entity.Agendamento;
import com.oitavarosado.clinica_api.domain.entity.Medico;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Optional<Agendamento> findByUuid(UUID uuid);

	List<Agendamento> findByDataConsulta(LocalDate dataConsulta);

	List<Agendamento> findByMedicoNome(String nomeMedico);

	List<Agendamento> findByDataConsultaAndHoraConsulta(LocalDate dataConsulta, LocalTime horaConsulta);

	boolean existsByDataConsultaAndHoraConsulta(LocalDate dataConsulta, LocalTime horaConsulta);

	List<Agendamento> findByMedicoAndDataConsultaAndHoraConsulta(Medico medico, LocalDate dataConsulta,
			LocalTime horaConsulta);

}
