package com.kenny.app.consultas.consultas_medicas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.MedicalAppointmentResponseDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.MedicalsAppointmentDetailsDTO;
import com.kenny.app.consultas.consultas_medicas.services.MedicalAppointmentService;

@RestController
@RequestMapping("/med-app")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;



    @GetMapping("/list")
    public ResponseEntity<List<MedicalAppointmentResponseDTO>> findAll(){
        return ResponseEntity.ok().body(medicalAppointmentService.findAll());
    }


    @GetMapping("list-details")
    public ResponseEntity<List<MedicalsAppointmentDetailsDTO>> finaAllDetails(){
        return ResponseEntity.ok().body(medicalAppointmentService.findAllDetails());
    }


    @GetMapping("/{id}")
    public ResponseEntity<MedicalAppointmentResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(medicalAppointmentService.findById(id));
    }



    @PostMapping("/create")
    public ResponseEntity<MedicalAppointmentResponseDTO> create(@RequestBody MedicalAppointmentRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalAppointmentService.create(dto));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalAppointmentResponseDTO> update(@PathVariable Long id, @RequestBody MedicalAppointmentRequestDTO dto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(medicalAppointmentService.update(id, dto));
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){
        Map<String, String> ok = new HashMap<>();
        medicalAppointmentService.delete(id);

        ok.put("message", "Eliminado con exito");
        return ResponseEntity.ok().body(ok);
    }
}
