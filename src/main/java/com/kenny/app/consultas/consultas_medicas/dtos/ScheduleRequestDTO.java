package com.kenny.app.consultas.consultas_medicas.dtos;

import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ScheduleRequestDTO {

    @NotEmpty(message = "No puede estar vacio")
    private String day;

    @FutureOrPresent(message = "No puede ser una hora anterior")
    @NotNull(message = "No puede estar vacio")
    private LocalTime startTime;

    @FutureOrPresent(message = "No puede ser una hora anterior")
    @NotNull(message = "No puede estar vacio")
    private LocalTime endTime;

    
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
