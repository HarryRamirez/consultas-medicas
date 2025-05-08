package com.kenny.app.consultas.consultas_medicas.dtos;

public class OfficeRequestDTO {

    private String number;
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
