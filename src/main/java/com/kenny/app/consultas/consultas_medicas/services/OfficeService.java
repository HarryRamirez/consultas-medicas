package com.kenny.app.consultas.consultas_medicas.services;

import java.util.List;

import com.kenny.app.consultas.consultas_medicas.dtos.OfficeRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.OfficeResponseDTO;

public interface OfficeService {

    List<OfficeResponseDTO> findAll();
    OfficeResponseDTO findById(Long id);
    OfficeResponseDTO create(OfficeRequestDTO dto);
    OfficeResponseDTO update(Long id, OfficeRequestDTO dto);
    void delete(Long id);
}
