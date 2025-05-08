package com.kenny.app.consultas.consultas_medicas.mapper;

import org.springframework.stereotype.Component;

import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.entities.MedicalAppointment;
import com.kenny.app.consultas.consultas_medicas.entities.Patient;

@Component
public class MedicalAppointmentMapper {



    public MedicalAppointment toEntity(MedicalAppointmentRequestDTO dto){
        MedicalAppointment medicalAppointment = new MedicalAppointment();
        medicalAppointment.setDate(dto.getDate());
        medicalAppointment.setReason(dto.getReason());

        Doctor doctor = new Doctor();
        doctor.setId(dto.getDoctorId());

        Patient patient = new Patient();
        patient.setId(dto.getPatientId());

        medicalAppointment.setDoctor(doctor);
        medicalAppointment.setPatient(patient);

        return medicalAppointment;
    }



    public MedicalAppointmentResponseDTO toDto(MedicalAppointment medicalAppointment){
        MedicalAppointmentResponseDTO dto = new MedicalAppointmentResponseDTO();
        dto.setId(medicalAppointment.getId());
        dto.setDate(medicalAppointment.getDate());
        dto.setReason(medicalAppointment.getReason());
        dto.setDoctorId(medicalAppointment.getDoctor().getId());
        dto.setPatientId(medicalAppointment.getPatient().getId());

        return dto;
    }


    

    public void updateMedicalAppointmentFromDto(MedicalAppointmentRequestDTO dto, MedicalAppointment medicalAppointment){
        medicalAppointment.setDate(dto.getDate());
        medicalAppointment.setReason(dto.getReason());

        Doctor doctor = new Doctor();
        doctor.setId(dto.getDoctorId());

        Patient patient = new Patient();
        patient.setId(dto.getDoctorId());

        if(doctor.getId() != null && patient.getId() != null){
        medicalAppointment.setDoctor(doctor);
        medicalAppointment.setPatient(patient);
        }
    }
}
