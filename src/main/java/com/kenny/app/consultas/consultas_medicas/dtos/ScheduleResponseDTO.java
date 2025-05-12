package com.kenny.app.consultas.consultas_medicas.dtos;

import java.time.LocalTime;

public class ScheduleResponseDTO {

    private Long id;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    
}
