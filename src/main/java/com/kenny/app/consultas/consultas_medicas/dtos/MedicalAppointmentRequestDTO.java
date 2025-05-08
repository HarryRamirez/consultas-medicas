package com.kenny.app.consultas.consultas_medicas.dtos;

import java.time.LocalDateTime;

public class MedicalAppointmentRequestDTO {

    private LocalDateTime date;
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
