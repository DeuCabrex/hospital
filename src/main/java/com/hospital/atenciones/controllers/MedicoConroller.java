package com.hospital.atenciones.controllers;

import com.hospital.atenciones.models.Medico;
import com.hospital.atenciones.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
@Validated
public class MedicoConroller {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Medico>findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findById(id));
    }

    @GetMapping("/run/{run}")
    public ResponseEntity<Medico>findByRun(@PathVariable String run){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findByRun(run));
    }
    @PostMapping
    public ResponseEntity<Medico> save (@Valid @RequestBody Medico medico){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medico));
    }
    @PostMapping("/{id}")
    public ResponseEntity<Medico> delete (@Valid @RequestBody Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Medico> update (@PathVariable Long id, @Valid @RequestBody Medico medico){
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.updateById(id, medico));
    }

}
