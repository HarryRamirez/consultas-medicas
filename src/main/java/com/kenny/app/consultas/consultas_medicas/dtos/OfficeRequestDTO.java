package com.kenny.app.consultas.consultas_medicas.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OfficeRequestDTO {

    @NotEmpty(message = "Agrega un numero")
    private String number;

    @NotNull(message = "Este campo es obligatorio")
    @Positive(message = "Debe ser mayor a 0")
    private Integer floor;
    private Long doctorId;
    
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public Long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    
}
