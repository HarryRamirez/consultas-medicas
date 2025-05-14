package com.kenny.app.consultas.consultas_medicas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.consultas.consultas_medicas.dtos.OfficeRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.OfficeResponseDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.entities.Office;
import com.kenny.app.consultas.consultas_medicas.exceptions.DuplicateResourceException;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.mapper.OfficeMapper;
import com.kenny.app.consultas.consultas_medicas.repositories.DoctorRepository;
import com.kenny.app.consultas.consultas_medicas.repositories.OfficeRepository;
import com.kenny.app.consultas.consultas_medicas.services.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private OfficeMapper mapper;



    @Transactional(readOnly = true)
    @Override
    public List<OfficeResponseDTO> findAll() {
        return officeRepository.findAll().stream()
        .map(mapper::toDto).collect(Collectors.toList());
    }



    @Transactional(readOnly = true)
    @Override
    public OfficeResponseDTO findById(Long id) {
        Office office = officeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Consultorio no encontrado"));

        return mapper.toDto(office);
    }


    @Transactional
    @Override
    public OfficeResponseDTO create(OfficeRequestDTO dto) {

        if(officeRepository.existsByNumber(dto.getNumber())){
            throw new DuplicateResourceException("Ya hay un consultorio con ese numero");
        }

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
        .orElseThrow(() -> new ResourceNotFoundException("El doctor no existe"));

        Office office = mapper.toEntity(dto);
        office.setDoctor(doctor);

        return mapper.toDto(officeRepository.save(office));
    }



    @Transactional
    @Override
    public OfficeResponseDTO update(Long id, OfficeRequestDTO dto) {
        Office office = officeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No fue actualizado"));
        mapper.updateOfficeFromDto(dto, office);

        return mapper.toDto(office);
    }



    @Transactional
    @Override
    public void delete(Long id) {
        Office office = officeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo eliminar"));

        Doctor doctor = office.getDoctor();
        if(doctor != null){
            doctor.setOffice(null);
            office.setDoctor(null);
        }
        officeRepository.delete(office);
    }


}
