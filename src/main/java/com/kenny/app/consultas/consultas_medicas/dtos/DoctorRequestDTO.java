package com.kenny.app.consultas.consultas_medicas.dtos;

import jakarta.validation.constraints.NotEmpty;

public class DoctorRequestDTO {

    @NotEmpty(message = "ingresa un nombre")
    private String name;

    @NotEmpty(message = "Debe asignar una especialidad")
    private String specialty;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    
}
