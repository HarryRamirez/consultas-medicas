package com.kenny.app.consultas.consultas_medicas.dtos;

import java.time.LocalTime;

public class ScheduleResponseDTO {

    private Long id;
    private String day;
    private LocalTime start_time;
    private LocalTime end_time;
    
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
    public LocalTime getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }
    public LocalTime getEnd_time() {
        return end_time;
    }
    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    
}
