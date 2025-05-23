package com.kenny.app.consultas.consultas_medicas.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenny.app.consultas.consultas_medicas.entities.MedicalAppointment;

public interface MedicalAppointmentRepository  extends JpaRepository<MedicalAppointment, Long>{

    boolean existsByDate(LocalDateTime date);

    List<MedicalAppointment> findByDate(LocalDateTime date);
}
