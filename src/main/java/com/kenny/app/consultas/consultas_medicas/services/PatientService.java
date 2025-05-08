package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;

import com.kenny.app.consultas.consultas_medicas.dtos.PatientRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.PatientResponseDTO;

public interface PatientService {

    List<PatientResponseDTO> findAll();
    PatientResponseDTO findById(Long id);
    PatientResponseDTO create(PatientRequestDTO dto);
    PatientResponseDTO update(Long id, PatientRequestDTO dto);
    void delete(Long id);
}
