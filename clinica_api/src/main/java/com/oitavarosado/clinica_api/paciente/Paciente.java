package com.oitavarosado.clinica_api.paciente;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="pacientes")
@Table(name="Paciente")
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
	
	@NotBlank
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
    @Past(message = "A data de nascimento deve ser uma data passada")
	private LocalDate dataNascimento;
	@NotBlank
	private String cpf;
	@NotBlank
	private String rg;
	@NotBlank
	private String orgaoEmissor;
	@NotBlank
	private String logradouro; 
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private Uf uf;
	@NotBlank
	private String cep;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String observacoes;
}
