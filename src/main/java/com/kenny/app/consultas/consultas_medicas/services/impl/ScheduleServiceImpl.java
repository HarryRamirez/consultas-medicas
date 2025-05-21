package com.kenny.app.consultas.consultas_medicas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Schedule;
import com.kenny.app.consultas.consultas_medicas.exceptions.DuplicateResourceException;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.mapper.ScheduleMapper;
import com.kenny.app.consultas.consultas_medicas.repositories.ScheduleRepository;
import com.kenny.app.consultas.consultas_medicas.services.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper mapper;





    @Transactional(readOnly = true)
    @Override
    public List<ScheduleResponseDTO> findAll() {
        return scheduleRepository.findAll().stream()
        .map(mapper::toDto).collect(Collectors.toList());
    }






    @Transactional(readOnly = true)
    @Override
    public ScheduleResponseDTO findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        return mapper.toDto(schedule);
    }





    @Transactional
    @Override
    public ScheduleResponseDTO create(ScheduleRequestDTO dto) {
        Schedule schedule = mapper.toEntity(dto);
        if(!dto.getEndTime().isAfter(dto.getStartTime())){
            throw new DuplicateResourceException("El tiempo final debe ser posterior al de inicio");
        }

        if(scheduleRepository.existsByDayAndStartTimeAndEndTime(dto.getDay(), dto.getStartTime(), dto.getEndTime())){
            throw new DuplicateResourceException("Horario no esta disponible");
        }

        return mapper.toDto(scheduleRepository.save(schedule));
    }




    @Transactional
    @Override
    public ScheduleResponseDTO update(Long id, ScheduleRequestDTO dto) {
        Schedule schedule = scheduleRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro el horario"));

        if(!dto.getEndTime().isAfter(dto.getStartTime())){
            throw new DuplicateResourceException("El tiempo final debe ser posterior al de inicio");
        }

        if(scheduleRepository.existsByDayAndStartTimeAndEndTime(dto.getDay(), dto.getStartTime(), dto.getEndTime())){
            throw new DuplicateResourceException("Horario no esta disponible");
        }
        mapper.updateScheduleFromDto(dto, schedule);

        return mapper.toDto(schedule);

    }





    @Transactional
    @Override
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo eliminar"));

        scheduleRepository.delete(schedule);
    }





    @Transactional(readOnly = true)
    @Override
    public List<ScheduleResponseDTO> search(String day) {
        return scheduleRepository.findByDayContainingIgnoreCase(day).stream()
        .map(mapper::toDto).toList();
    }

}
