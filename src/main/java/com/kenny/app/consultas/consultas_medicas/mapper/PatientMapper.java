package com.kenny.app.consultas.consultas_medicas.mapper;

import org.springframework.stereotype.Component;

import com.kenny.app.consultas.consultas_medicas.dtos.PatientRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.PatientResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Patient;

@Component
public class PatientMapper {



    public Patient toEntity(PatientRequestDTO dto){
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setDocument(dto.getDocument());
        return patient;
    }


    public PatientResponseDTO toDto(Patient patient){
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setDocument(patient.getDocument());
        return dto;
    }

    public void updatePatientFromDto(PatientRequestDTO dto, Patient patient){
        patient.setName(dto.getName());
        patient.setDocument(dto.getDocument());
    }
}
