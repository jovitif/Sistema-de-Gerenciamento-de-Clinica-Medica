package com.oitavarosado.clinica_api.api.dto.paciente;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import com.oitavarosado.clinica_api.domain.entity.Sexo;
import com.oitavarosado.clinica_api.domain.entity.Uf;

public record InsertPacienteDTO(
        @NotBlank(message = "Nome não pode estar em branco")
        String nome,
        
        @NotNull(message = "Sexo é obrigatório")
        Sexo sexo,
        
        @Past(message = "Data de nascimento deve ser no passado")
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataNascimento,
        
        @CPF(message = "CPF inválido")
        @NotBlank(message = "CPF não pode estar em branco")
        String cpf,
        
        @NotBlank(message = "RG não pode estar em branco")
        String rg,
        
        @NotBlank(message = "Órgão Emissor não pode estar em branco")
        String orgaoEmissor,
        
        @NotBlank(message = "Logradouro não pode estar em branco")
        String logradouro,
        
        @NotBlank(message = "Bairro não pode estar em branco")
        String bairro,
        
        @NotBlank(message = "Cidade não pode estar em branco")
        String cidade,
        
        @NotNull(message = "UF é obrigatória")
        Uf uf,
        
        @NotBlank(message = "CEP não pode estar em branco")
        String cep,
        
        @NotBlank(message = "Telefone não pode estar em branco")
        String telefone,
        
        @Email(message = "E-mail inválido")
        @NotBlank(message = "E-mail não pode estar em branco")
        String email,
        
        String observacoes) {

}

