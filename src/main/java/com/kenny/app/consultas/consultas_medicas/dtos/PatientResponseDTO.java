package com.kenny.app.consultas.consultas_medicas.dtos;

public class PatientResponseDTO {

    private Long id;
    private String name;
    private String document;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }

    
}
