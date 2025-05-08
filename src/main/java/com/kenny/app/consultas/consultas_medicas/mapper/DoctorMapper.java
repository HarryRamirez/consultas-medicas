package com.kenny.app.consultas.consultas_medicas.mapper;

import org.springframework.stereotype.Component;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDTO dto){
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        return doctor;
    }


    public DoctorResponseDTO toDto(Doctor doctor){
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());

        return dto;
    }

    

    public void updateDtoFromDoctor(DoctorRequestDTO dto, Doctor doctor){
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
    }
}
