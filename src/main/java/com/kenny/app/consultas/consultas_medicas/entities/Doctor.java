package com.kenny.app.consultas.consultas_medicas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;

    @ManyToMany
    @JoinTable(name = "doctor_schedule", joinColumns = @JoinColumn(name = "doctor_id"),
    inverseJoinColumns = @JoinColumn(name = "schedule_id"))// esto es para el que va ser el dueño de la relacion
    private List<Schedule> schedules;

    /* 
    @OneToOne(mappedBy = "doctor")// para el lado contrario bidirec, el que no tien el fk
    private Office office;
    */

    
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
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public List<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    /* 
    public Office getOffice() {
        return office;
    }
    public void setOffice(Office office) {
        this.office = office;
    }
    */

}
