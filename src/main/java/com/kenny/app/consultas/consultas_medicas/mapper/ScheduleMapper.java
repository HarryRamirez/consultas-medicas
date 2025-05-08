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
        schedule.setStart_time(dto.getStart_time());
        schedule.setEnd_time(dto.getEnd_time());
        return schedule;
    }



    public ScheduleResponseDTO toDto(Schedule schedule){
        ScheduleResponseDTO dto = new ScheduleResponseDTO();
        dto.setId(schedule.getId());
        dto.setDay(schedule.getDay());
        dto.setStart_time(schedule.getStart_time());
        dto.setEnd_time(schedule.getEnd_time());
        return dto;
    }


    public void updateScheduleFromDto(ScheduleRequestDTO dto, Schedule schedule){
        schedule.setDay(dto.getDay());
        schedule.setStart_time(dto.getStart_time());
        schedule.setEnd_time(dto.getEnd_time());
    }

}
