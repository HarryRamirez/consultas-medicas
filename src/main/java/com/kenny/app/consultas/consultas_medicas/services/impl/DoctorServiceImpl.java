package com.kenny.app.consultas.consultas_medicas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDetailDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDetailDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.entities.Schedule;
import com.kenny.app.consultas.consultas_medicas.exceptions.DuplicateResourceException;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.mapper.DoctorMapper;
import com.kenny.app.consultas.consultas_medicas.repositories.DoctorRepository;
import com.kenny.app.consultas.consultas_medicas.repositories.ScheduleRepository;
import com.kenny.app.consultas.consultas_medicas.services.DoctorService;




@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

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
    public List<DoctorResponseDetailDTO> findDetails() {
        return doctorRepository.findAll().stream()
        .map(mapper::toDtoDetail).collect(Collectors.toList());
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




    @Transactional
    @Override
    public DoctorResponseDetailDTO createDetails(DoctorRequestDetailDTO dto) {
        // Verifica si el doctor ya existe por nombre
        if (doctorRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new DuplicateResourceException("Ya hay un doctor con ese nombre");
        }

        // Verifica que los horarios existan en la base de datos
        List<Schedule> schedules = scheduleRepository.findAllById(dto.getSchedules());
    
        if (schedules.size() != dto.getSchedules().size()) {
            // Si el número de horarios encontrados no es igual al de los enviados, lanza excepción
            throw new ResourceNotFoundException("Uno o más horarios no encontrados");
        }

    
        // Mapea DTO a entidad Doctor
        Doctor doctor = mapper.toEntityDetail(dto);

        // Establece la relación entre Doctor y los Schedule encontrados
        doctor.setSchedules(schedules);

        // Guarda el doctor con la relación en la tabla intermedia
        doctor = doctorRepository.save(doctor);

        // Devuelve el DTO de respuesta
        return mapper.toDtoDetail(doctor);
    }




    @Transactional
    @Override
    public DoctorResponseDTO update(Long id, DoctorRequestDTO dto) {
         Doctor doctor = doctorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("doctor no encontrado, no se pude actualizar"));
        mapper.updateDtoFromDoctor(dto, doctor);

        return mapper.toDto(doctorRepository.save(doctor));
    }





    @Transactional
    @Override
    public void delete(Long id) {
        Doctor doctor = doctorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo eliminar"));

        doctorRepository.delete(doctor);
    }





    @Override
    public List<DoctorResponseDTO> findByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name).stream()
        .map(mapper::toDto).collect(Collectors.toList());
    }

}
