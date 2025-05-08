package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;

import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentResponseDTO;

public interface MedicalAppointmentService {

    List<MedicalAppointmentResponseDTO> findAll();
    MedicalAppointmentResponseDTO findById(Long id);
    MedicalAppointmentResponseDTO create(MedicalAppointmentRequestDTO dto);
    MedicalAppointmentResponseDTO update(Long id, MedicalAppointmentRequestDTO dto);
    void delete(Long id);
}
