package com.kenny.app.consultas.consultas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenny.app.consultas.consultas_medicas.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
