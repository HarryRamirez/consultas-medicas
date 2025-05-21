package com.kenny.app.consultas.consultas_medicas.dtos;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class DoctorRequestDetailDTO {

    @NotEmpty(message = "ingresa un nombre")
    private String name;

    @NotEmpty(message = "Debe asignar una especialidad")
    private String specialty;
    private List<Long> schedules;
    
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
    public List<Long> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Long> schedules) {
        this.schedules = schedules;
    }

    
}
