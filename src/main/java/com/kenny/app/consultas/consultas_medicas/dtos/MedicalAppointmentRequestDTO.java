package com.kenny.app.consultas.consultas_medicas.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MedicalAppointmentRequestDTO {

    @NotNull(message = "Agrega una fecha")
    @FutureOrPresent(message = "la fecha no puede ser anterior")
    private LocalDateTime date;

    @NotEmpty(message = "Este capo no puede estar vacio")
    private String reason;
    private Long doctorId;
    private Long patientId;

    
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
    public Long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    
}
