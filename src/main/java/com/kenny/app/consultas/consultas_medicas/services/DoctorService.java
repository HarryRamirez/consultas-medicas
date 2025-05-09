package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;

public interface DoctorService {

    List<DoctorResponseDTO> findAll();
    DoctorResponseDTO findById(Long id);
    DoctorResponseDTO create(DoctorRequestDTO dto);
    DoctorResponseDTO update(Long id, DoctorRequestDTO dto);
    void delete(Long id);
}
