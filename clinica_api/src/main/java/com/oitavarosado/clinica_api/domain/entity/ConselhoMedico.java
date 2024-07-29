package com.oitavarosado.clinica_api.domain.entity;

public enum ConselhoMedico {
    CRM("Conselho Regional de Medicina"),
    CRO("Conselho Regional de Odontologia"),
    CRV("Conselho Regional de Veterinária"),
    CREFITO("Conselho Regional de Fisioterapia e Terapia Ocupacional"),
    CREFONO("Conselho Regional de Fonoaudiologia"),
    CRN("Conselho Regional de Nutrição"),
    CREF("Conselho Regional de Educação Física"),
    COREN("Conselho Regional de Enfermagem"),
    CFP("Conselho Federal de Psicologia");

    private final String descricao;

    ConselhoMedico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
