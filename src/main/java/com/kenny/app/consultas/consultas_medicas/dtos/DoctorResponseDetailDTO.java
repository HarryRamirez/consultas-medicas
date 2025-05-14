package com.kenny.app.consultas.consultas_medicas.dtos;

import java.util.List;

public class DoctorResponseDetailDTO {
    private Long id;
    private String name;
    private String specialty;
    private List<ScheduleResponseDTO> schedules;


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
    public List<ScheduleResponseDTO> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<ScheduleResponseDTO> schedules) {
        this.schedules = schedules;
    }


    
}
