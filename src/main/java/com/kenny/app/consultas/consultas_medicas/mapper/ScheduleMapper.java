package com.kenny.app.consultas.consultas_medicas.mapper;

import org.springframework.stereotype.Component;

import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Schedule;

@Component
public class ScheduleMapper {



    public Schedule toEntity(ScheduleRequestDTO dto){
        Schedule schedule = new Schedule();
        schedule.setDay(dto.getDay());
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
        return schedule;
    }



    public ScheduleResponseDTO toDto(Schedule schedule){
        ScheduleResponseDTO dto = new ScheduleResponseDTO();
        dto.setId(schedule.getId());
        dto.setDay(schedule.getDay());
        dto.setStartTime(schedule.getStartTime());
        dto.setEndTime(schedule.getEndTime());
        return dto;
    }


    public void updateScheduleFromDto(ScheduleRequestDTO dto, Schedule schedule){
        schedule.setDay(dto.getDay());
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
    }

}
