package com.kenny.app.consultas.consultas_medicas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.exceptions.DuplicateResourceException;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.mapper.DoctorMapper;
import com.kenny.app.consultas.consultas_medicas.repositories.DoctorRepository;
import com.kenny.app.consultas.consultas_medicas.services.DoctorService;




@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public List<DoctorResponseDTO> findAll() {
        return doctorRepository.findAll().stream()
        .map(mapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public DoctorResponseDTO findById(Long id) {
        Doctor doctor =  doctorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));

        return mapper.toDto(doctor);
    }

    @Transactional
    @Override
    public DoctorResponseDTO create(DoctorRequestDTO dto) {
        Doctor doctor = mapper.toEntity(dto);
        if(doctorRepository.existsByNameIgnoreCase(dto.getName())){
            throw new DuplicateResourceException("Ya hay un doctor con ese nombre");
        }
        return mapper.toDto(doctorRepository.save(doctor));
    }

    @Override
    public DoctorResponseDTO update(Long id, DoctorRequestDTO dto) {
         Doctor doctor = doctorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("doctor no encontrado, no se pude actualizar"));
        mapper.updateDtoFromDoctor(dto, doctor);

        return mapper.toDto(doctorRepository.save(doctor));
    }



    @Override
    public void delete(Long id) {
        Doctor doctor = doctorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo eliminar"));

        doctorRepository.delete(doctor);
    }

}
