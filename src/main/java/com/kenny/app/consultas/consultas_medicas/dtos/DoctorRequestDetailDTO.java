package com.kenny.app.consultas.consultas_medicas.dtos;

import java.util.List;

public class DoctorRequestDetailDTO {
    private String name;
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
