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
import org.springframework.web.bind.annotation.RestController;

import com.kenny.app.consultas.consultas_medicas.dtos.DoctorRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.DoctorResponseDTO;
import com.kenny.app.consultas.consultas_medicas.services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    public ResponseEntity<List<DoctorResponseDTO>> findAll(){
        return ResponseEntity.ok().body(doctorService.findAll());

    }


    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(doctorService.findById(id));
    }


    @PostMapping("/create")
    public ResponseEntity<DoctorResponseDTO> create(@RequestBody DoctorRequestDTO dto){
        return ResponseEntity.ok().body(doctorService.create(dto));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DoctorResponseDTO> update(@PathVariable Long id, @RequestBody DoctorRequestDTO dto){
        return ResponseEntity.ok().body(doctorService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        doctorService.delete(id);
        return ResponseEntity.ok("Se Elimino con Exito");
    }
}
