package com.kenny.app.consultas.consultas_medicas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenny.app.consultas.consultas_medicas.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, Long>{

    boolean existsByNumber(String number);

    List<Office> findByNumber(String number);
}
