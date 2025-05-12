package com.kenny.app.consultas.consultas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenny.app.consultas.consultas_medicas.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long>{

    boolean existsByDocument(String document);
}
