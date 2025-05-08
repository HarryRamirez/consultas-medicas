package com.kenny.app.consultas.consultas_medicas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;

    @OneToMany
    private List<MedicalAppointment> medicalsAppointments;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public List<MedicalAppointment> getMedicalsAppointments() {
        return medicalsAppointments;
    }
    public void setMedicalsAppointments(List<MedicalAppointment> medicalsAppointments) {
        this.medicalsAppointments = medicalsAppointments;
    }

    
}
