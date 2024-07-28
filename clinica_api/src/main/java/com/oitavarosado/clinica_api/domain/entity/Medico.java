package com.oitavarosado.clinica_api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Medico")
@Table(name = "tb_medicos")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	String nome;
	String conselhoMedico;
	String ufConselho;
	String numConselho;
	String classBrasileira;
	String cpf;
	String logradouro;
	String bairro;
	String cidade;
	String uf;
	String cep;
	String telefone;
	String email;
	
}
