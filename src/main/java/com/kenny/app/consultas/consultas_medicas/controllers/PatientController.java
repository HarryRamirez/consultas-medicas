package com.kenny.app.consultas.consultas_medicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kenny.app.consultas.consultas_medicas.dtos.PatientRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.PatientResponseDTO;
import com.kenny.app.consultas.consultas_medicas.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/list")
    public ResponseEntity<List<PatientResponseDTO>> findAll(){
        return ResponseEntity.ok().body(patientService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(patientService.findById(id));
    }



    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientRequestDTO dto){
        return ResponseEntity.ok().body(patientService.create(dto));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<PatientResponseDTO> update(@PathVariable Long id, @RequestBody PatientRequestDTO dto){
        return ResponseEntity.ok().body(patientService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        patientService.delete(id);
        return ResponseEntity.ok().body("Eliminado con exito");
    }


    @GetMapping("/search")
    public ResponseEntity<PatientResponseDTO> search(@RequestParam String document){
        PatientResponseDTO result = patientService.search(document);
        return ResponseEntity.ok().body(result);

    }

}
