package com.oitavarosado.clinica_api.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.oitavarosado.clinica_api.api.dto.paciente.InsertPacienteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pacientes")
public class Paciente {

	public Paciente(Paciente data) {

	}

	public Paciente() {

	}

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(updatable = false, nullable = false)
	private UUID uuid = UUID.randomUUID();

	@NotBlank(message = "O nome é obrigatório")
	@Column(nullable = false)
	private String nome;

	@NotNull(message = "O sexo é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sexo sexo;

	@Past(message = "A data de nascimento deve ser uma data passada")
	@NotNull(message = "A data de nascimento é obrigatória")
	private LocalDate dataNascimento;

	@NotBlank(message = "O CPF é obrigatório")
	@Column(nullable = false)
	private String cpf;

	@NotBlank(message = "O RG é obrigatório")
	@Column(nullable = false)
	private String rg;

	@NotBlank(message = "O órgão emissor é obrigatório")
	@Column(nullable = false)
	private String orgaoEmissor;

	@NotBlank(message = "O logradouro é obrigatório")
	@Column(nullable = false)
	private String logradouro;

	@NotBlank(message = "O bairro é obrigatório")
	@Column(nullable = false)
	private String bairro;

	@NotBlank(message = "A cidade é obrigatória")
	@Column(nullable = false)
	private String cidade;

	@NotNull(message = "A UF é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Uf uf;

	@NotBlank(message = "O CEP é obrigatório")
	@Column(nullable = false)
	private String cep;

	@NotBlank(message = "O telefone é obrigatório")
	@Column(nullable = false)
	private String telefone;

	@Email(message = "O e-mail deve ser válido")
	@NotBlank(message = "O e-mail é obrigatório")
	@Column(nullable = false)
	private String email;

	private String observacoes;

	public Paciente(UUID uuid, String nome, Sexo sexo, LocalDate dataNascimento, String cpf, String rg,
			String orgaoEmissor, String logradouro, String bairro, String cidade, Uf uf, String cep, String telefone,
			String email, String observacoes) {
		this.uuid = uuid;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.observacoes = observacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	

}
