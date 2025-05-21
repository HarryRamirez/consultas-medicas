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

import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.ScheduleResponseDTO;
import com.kenny.app.consultas.consultas_medicas.services.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @GetMapping("/list")
    public ResponseEntity<List<ScheduleResponseDTO>> findAll(){
        return ResponseEntity.ok().body(scheduleService.findAll());
    }


    @GetMapping("{id}")
    public ResponseEntity<ScheduleResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(scheduleService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduleResponseDTO> create(@RequestBody ScheduleRequestDTO dto){
        return ResponseEntity.ok().body(scheduleService.create(dto));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ScheduleResponseDTO> update(@PathVariable Long id, @RequestBody ScheduleRequestDTO dto){
        return ResponseEntity.ok().body(scheduleService.update(id, dto));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return ResponseEntity.ok().body("Eliminado con exito");
    }


    @GetMapping("/search")
    public ResponseEntity<List<ScheduleResponseDTO>> search(@RequestParam String day){
        List<ScheduleResponseDTO> results = scheduleService.search(day);
        return ResponseEntity.ok().body(results);
    }
}
