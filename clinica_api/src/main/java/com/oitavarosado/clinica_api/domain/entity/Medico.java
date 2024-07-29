package com.oitavarosado.clinica_api.domain.entity;

import java.util.UUID;

import com.oitavarosado.clinica_api.api.dto.medico.InsertMedicoDTO;

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

@Entity
@Table(name = "tb_medicos")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(updatable = false, nullable = false, unique = true)
	private UUID uuid = UUID.randomUUID();

	@NotBlank(message = "O nome é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotNull(message = "O conselho medico é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ConselhoMedico conselhoMedico;
	
	@NotNull(message = "A UF do conselho é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Uf ufConselho;
	
	@NotBlank(message = "O nome é obrigatório")
	@Column(nullable = false)
	private String numConselho;
	
	@NotNull(message = "A Classificação brasileira de ocupações é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CategoriaCBO classBrasileira;
	@NotBlank(message = "O CPF é obrigatório")
	@Column(unique = true, nullable = false)
	private String cpf;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ConselhoMedico getConselhoMedico() {
		return conselhoMedico;
	}

	public void setConselhoMedico(ConselhoMedico conselhoMedico) {
		this.conselhoMedico = conselhoMedico;
	}

	public Uf getUfConselho() {
		return ufConselho;
	}

	public void setUfConselho(Uf ufConselho) {
		this.ufConselho = ufConselho;
	}

	public String getNumConselho() {
		return numConselho;
	}

	public void setNumConselho(String numConselho) {
		this.numConselho = numConselho;
	}

	public CategoriaCBO getClassBrasileira() {
		return classBrasileira;
	}

	public void setClassBrasileira(CategoriaCBO classBrasileira) {
		this.classBrasileira = classBrasileira;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public Medico(Medico data) {

	}

	public Medico() {

	}
	
	public Medico(InsertMedicoDTO data) {
		this.bairro = data.bairro();
		this.cep = data.cep();
		this.cidade = data.cidade();
		this.classBrasileira = data.classBrasileira();
		this.conselhoMedico = data.conselhoMedico();
		this.cpf = data.cpf();
		this.email = data.email();
		this.logradouro = data.logradouro();
		this.nome = data.nome();
		this.numConselho = data.numConselho();
		this.telefone = data.telefone();
		this.uf = data.uf();
		this.ufConselho = data.ufConselho();
	}
}
