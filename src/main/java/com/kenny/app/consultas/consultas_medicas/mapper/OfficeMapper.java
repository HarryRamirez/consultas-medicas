package com.kenny.app.consultas.consultas_medicas.mapper;

import org.springframework.stereotype.Component;

import com.kenny.app.consultas.consultas_medicas.dtos.OfficeRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.OfficeResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.entities.Office;

@Component
public class OfficeMapper {

    public Office toEntity(OfficeRequestDTO dto){
        Office office = new Office();
        office.setNumber(dto.getNumber());
        office.setFloor(dto.getFloor());

        Doctor doctor = new Doctor();
        doctor.setId(dto.getDoctorId());

        office.setDoctor(doctor);

        return office;
        
    }



    

    public OfficeResponseDTO toDto(Office office){
        OfficeResponseDTO dto = new OfficeResponseDTO();
        dto.setId(office.getId());
        dto.setNumber(office.getNumber());
        dto.setFloor(office.getFloor());

        if(office.getDoctor() != null){
        dto.setDoctorId(office.getDoctor().getId());
        }   

        return dto;
    }





    public void updateOfficeFromDto(OfficeRequestDTO dto, Office office){
        office.setNumber(dto.getNumber());
        office.setFloor(dto.getFloor());

        Doctor doctor = new Doctor();
        if(doctor.getId() != null){
        doctor.setId(dto.getDoctorId());

        office.setDoctor(doctor);
        }
    }
}
