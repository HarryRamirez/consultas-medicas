package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;
import java.util.Optional;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;

public interface DoctorService {

    List<DoctorResponseDTO> findAll();
    Optional<DoctorResponseDTO> findById(Long id);
    DoctorResponseDTO create(DoctorRequestDTO dto);
    Optional<DoctorResponseDTO> update(Long id, DoctorRequestDTO dto);
    void delete(Long id);
}
