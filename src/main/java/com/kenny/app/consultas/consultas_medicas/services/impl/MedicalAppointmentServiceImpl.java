package com.kenny.app.consultas.consultas_medicas.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentResponseDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.MedicalsAppointmentDetailsDTO;
import com.kenny.app.consultas.consultas_medicas.entities.Doctor;
import com.kenny.app.consultas.consultas_medicas.entities.MedicalAppointment;
import com.kenny.app.consultas.consultas_medicas.entities.Patient;
import com.kenny.app.consultas.consultas_medicas.exceptions.DuplicateResourceException;
import com.kenny.app.consultas.consultas_medicas.exceptions.ResourceNotFoundException;
import com.kenny.app.consultas.consultas_medicas.mapper.MedicalAppointmentMapper;
import com.kenny.app.consultas.consultas_medicas.repositories.DoctorRepository;
import com.kenny.app.consultas.consultas_medicas.repositories.MedicalAppointmentRepository;
import com.kenny.app.consultas.consultas_medicas.repositories.PatientRepository;
import com.kenny.app.consultas.consultas_medicas.services.MedicalAppointmentService;

@Service
public class MedicalAppointmentServiceImpl implements MedicalAppointmentService{

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalAppointmentMapper mapper;





    @Transactional(readOnly = true)
    @Override
    public List<MedicalAppointmentResponseDTO> findAll() {
        return medicalAppointmentRepository.findAll().stream()
        .map(mapper::toDto).collect(Collectors.toList());
    }

    
    @Transactional(readOnly = true)
    @Override
    public List<MedicalsAppointmentDetailsDTO> findAllDetails(){
        return medicalAppointmentRepository.findAll().stream()
        .map(mapper::toDtoDetails).collect(Collectors.toList());
    }

    

    @Transactional(readOnly = true)
    @Override
    public MedicalAppointmentResponseDTO findById(Long id) {
        MedicalAppointment meAp = medicalAppointmentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada"));

        return mapper.toDto(meAp);
    }





    @Transactional
    @Override
    public MedicalAppointmentResponseDTO create(MedicalAppointmentRequestDTO dto) {
       
        if(medicalAppointmentRepository.existsByDate(dto.getDate())){
            throw new DuplicateResourceException("Cita no disponible");
        }

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
        .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));

        Patient patient = patientRepository.findById(dto.getPatientId())
        .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));

        MedicalAppointment meAp = mapper.toEntity(dto);
        meAp.setDoctor(doctor);
        meAp.setPatient(patient);

        return mapper.toDto(medicalAppointmentRepository.save(meAp));
        
    }





    @Transactional
    @Override
    public MedicalAppointmentResponseDTO update(Long id, MedicalAppointmentRequestDTO dto) {
        MedicalAppointment meAp = medicalAppointmentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo actualizar"));
        mapper.updateMedicalAppointmentFromDto(dto, meAp);

        
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
        .orElseThrow(() -> new ResourceNotFoundException("El doctor no existe"));

        Patient patient = patientRepository.findById(dto.getPatientId())
        .orElseThrow(() -> new ResourceNotFoundException("El paciente no existe"));

        meAp.setDoctor(doctor);
        meAp.setPatient(patient);

        return mapper.toDto(meAp);
    }





    @Transactional
    @Override
    public void delete(Long id) {
        MedicalAppointment meAp = medicalAppointmentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se pudo eliminar"));

        Patient patient = meAp.getPatient();
        if(patient != null ){
            patient.getMedicalsAppointments().remove(meAp);
            meAp.setPatient(null);
        }

        medicalAppointmentRepository.delete(meAp);
    }


    @Transactional(readOnly = true)
    @Override
    public List<MedicalAppointmentResponseDTO> search(LocalDateTime date) {
         return medicalAppointmentRepository.findByDate(date).stream()
         .map(mapper::toDto).toList();
    }

}
