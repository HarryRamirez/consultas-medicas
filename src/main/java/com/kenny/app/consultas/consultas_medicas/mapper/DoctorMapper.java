package com.kenny.app.consultas.consultas_medicas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDetailDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDetailDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.entities.Schedule;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.repositories.ScheduleRepository;

@Component
public class DoctorMapper {

    @Autowired
    private ScheduleRepository scheduleRepository;


    public Doctor toEntity(DoctorRequestDTO dto){
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        return doctor;
    }

    public Doctor toEntityDetail(DoctorRequestDetailDTO dto){
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        // Convertimos los IDs en entidades Schedule
        if (dto.getSchedules() != null && !dto.getSchedules().isEmpty()) {
            List<Schedule> schedules = dto.getSchedules().stream()
                .map(id -> scheduleRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Horario con ID " + id + " no encontrado")))
                .collect(Collectors.toList());
            doctor.setSchedules(schedules);
        }

        return doctor;
    }


    public DoctorResponseDTO toDto(Doctor doctor){
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());

        return dto;
    }


    public DoctorResponseDetailDTO toDtoDetail(Doctor doctor){
        DoctorResponseDetailDTO dto = new DoctorResponseDetailDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        List<ScheduleResponseDTO> sd = doctor.getSchedules().stream()
        .map(schedule -> new ScheduleResponseDTO(
            schedule.getId(),
            schedule.getDay(),
            schedule.getStartTime(),
            schedule.getEndTime()))
        .collect(Collectors.toList());

        dto.setSchedules(sd);

        return dto;
    }

    

    public void updateDtoFromDoctor(DoctorRequestDTO dto, Doctor doctor){
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
    }
}
