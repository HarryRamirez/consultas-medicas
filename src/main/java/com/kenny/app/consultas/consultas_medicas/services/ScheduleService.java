package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;

import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleResponseDTO;

public interface ScheduleService {

    List<ScheduleResponseDTO> findAll();
    ScheduleResponseDTO findById(Long id);
    ScheduleResponseDTO create(ScheduleRequestDTO dto);
    ScheduleResponseDTO update(Long id, ScheduleRequestDTO dto);
    void delete(Long id);
}
