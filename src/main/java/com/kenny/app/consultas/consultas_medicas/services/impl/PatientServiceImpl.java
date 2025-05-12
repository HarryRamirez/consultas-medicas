package com.kenny.app.consultas.consultas_medicas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.consultas.consultas_medicas.dtos.PatientRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.PatientResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Patient;
import com.kenny.app.consultas.consultas_medicas.exceptions.DuplicateResourceException;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.mapper.PatientMapper;
import com.kenny.app.consultas.consultas_medicas.repositories.PatientRepository;
import com.kenny.app.consultas.consultas_medicas.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public List<PatientResponseDTO> findAll() {
        return patientRepository.findAll().stream()
        .map(mapper::toDto).collect(Collectors.toList());
    }



    @Transactional(readOnly = true)
    @Override
    public PatientResponseDTO findById(Long id) {
        Patient pattient = patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
        
        return mapper.toDto(pattient);
    }


    @Transactional
    @Override
    public PatientResponseDTO create(PatientRequestDTO dto) {
        Patient patient = mapper.toEntity(dto);
        if(patientRepository.existsByDocument(dto.getDocument())){
            throw new DuplicateResourceException("Ya existe un usuario con ese documento");
        }

        return mapper.toDto(patientRepository.save(patient));
    }



    @Transactional
    @Override
    public PatientResponseDTO update(Long id, PatientRequestDTO dto) {
        Patient patient = patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente no fue encontrado"));
        mapper.updatePatientFromDto(dto, patient);

        return mapper.toDto(patient);
    }



    @Override
    public void delete(Long id) {
        Patient patient = patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo eliminar"));

        patientRepository.delete(patient);
    }

}
