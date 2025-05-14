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

import com.kenny.app.consultas.consultas_medicas.dtos.OfficeRequestDTO;
import com.kenny.app.consultas.consultas_medicas.dtos.OfficeResponseDTO;
import com.kenny.app.consultas.consultas_medicas.services.OfficeService;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    
    @GetMapping("/list")
    public ResponseEntity<List<OfficeResponseDTO>> findAll(){
        return ResponseEntity.ok().body(officeService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<OfficeResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(officeService.findById(id));
    }


    @PostMapping("/create")
    public ResponseEntity<OfficeResponseDTO> create(@RequestBody OfficeRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(officeService.create(dto));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<OfficeResponseDTO> update(@PathVariable Long id, @RequestBody OfficeRequestDTO dto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(officeService.update(id, dto));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){
        Map<String, String> ok = new HashMap<>();
        officeService.delete(id);
        ok.put("message", "Eliminado exitosamente");
        return ResponseEntity.ok().body(ok);
    }
}
