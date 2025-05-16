package com.kenny.app.consultas.consultas_medicas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenny.app.consultas.consultas_medicas.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

    boolean existsByNameIgnoreCase(String name);

    List<Doctor> findByNameContainingIgnoreCase(String name);
}
