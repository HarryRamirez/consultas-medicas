package com.kenny.app.consultas.consultas_medicas.repositories;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenny.app.consultas.consultas_medicas.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

    
    boolean existsByDayAndStartTimeAndEndTime(String day, LocalTime startTime, LocalTime endTime);
}
