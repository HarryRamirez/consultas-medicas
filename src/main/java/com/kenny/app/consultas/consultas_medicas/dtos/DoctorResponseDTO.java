package com.kenny.app.consultas.consultas_medicas.dtos;

public class DoctorResponseDTO {

    private Long id;
    private String name;
    private String specialty;

    
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
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    
}
