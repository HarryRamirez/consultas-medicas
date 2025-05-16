package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDetailDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDetailDTO;

public interface DoctorService {

    List<DoctorResponseDTO> findAll();
    DoctorResponseDTO findById(Long id);
    List<DoctorResponseDetailDTO> findDetails();
    DoctorResponseDTO create(DoctorRequestDTO dto);
    DoctorResponseDetailDTO createDetails(DoctorRequestDetailDTO dto);
    DoctorResponseDTO update(Long id, DoctorRequestDTO dto);
    void delete(Long id);
    List<DoctorResponseDTO> findByName(String name);
}
