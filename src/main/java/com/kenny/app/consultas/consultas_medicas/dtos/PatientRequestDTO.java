package com.kenny.app.consultas.consultas_medicas.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotEmpty(message = "Escriba un nombre")
    private String name;

    @NotEmpty(message = "Eecriba su numero de documento")
    @Size(min = 8, message = "No puede ser menor a 8 digitos")
    private String document;

    
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
