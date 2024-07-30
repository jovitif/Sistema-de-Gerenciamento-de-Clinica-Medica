package com.oitavarosado.clinica_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oitavarosado.clinica_api.domain.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
