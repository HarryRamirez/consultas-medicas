package com.kenny.app.consultas.consultas_medicas.dtos;

import java.time.LocalDateTime;

public class MedicalsAppointmentDetailsDTO {

    private Long id;
    private LocalDateTime date;
    private String reason;
    private String doctor;
    private String patient;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getPatient() {
        return patient;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }

    
}
