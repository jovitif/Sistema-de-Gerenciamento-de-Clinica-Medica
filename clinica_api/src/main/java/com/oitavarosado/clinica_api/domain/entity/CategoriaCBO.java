package com.oitavarosado.clinica_api.domain.entity;

public enum CategoriaCBO {
    MEDICO("Médico"),
    ENFERMEIRO("Enfermeiro"),
    DENTISTA("Dentista"),
    FARMACEUTICO("Farmacêutico"),
    PSICOLOGO("Psicólogo");

    private final String descricao;

    CategoriaCBO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
