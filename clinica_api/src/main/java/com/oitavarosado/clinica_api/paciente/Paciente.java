package com.oitavarosado.clinica_api.paciente;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="pacientes")
@Table(name="paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {
	
	public Paciente(InsertPacienteDTO dados) {
		// TODO Auto-generated constructor stub
	this.bairro = dados.bairro();
	this.cep = dados.cep();
	this.cidade = dados.cidade();
	this.cpf = dados.cpf();
	this.dataNascimento = dados.dataNascimento();
	this.email = dados.email();
	this.logradouro = dados.logradouro();
	this.nome = dados.nome();
	this.observacoes = dados.observacoes();
	this.orgaoEmissor = dados.orgaoEmissor();
	this.rg = dados.rg();
	this.sexo = dados.sexo();
	this.telefone = dados.telefone();
	this.uf = dados.uf();
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	@Enumerated(EnumType.STRING)
	
	private Sexo sexo;
	private LocalDate dataNascimento;
	private String cpf;
	private String rg;
	private String orgaoEmissor;
	private String logradouro; 
	private String bairro;
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
	private String cep;
	private String telefone;
	private String email;
	private String observacoes;
}
