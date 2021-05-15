/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uv.crud.controller;

import com.uv.crud.model.Empleado;
import com.uv.crud.repository.EmpleadoCrudRepo;
import java.util.List;
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

/**
 *
 * @author jahaziel
 */
@RestController
@RequestMapping("/api/v1/crud")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoCrudRepo crudRepo;

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> addEmpdo(@RequestBody Empleado empleado) {
        try {
            Empleado empdo = crudRepo.save(empleado);
            return new ResponseEntity<>(empdo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>> getAllEmpdos() {
        try {
            List<Empleado> empleados = crudRepo.findAll();
            if (empleados.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(empleados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> getEmpdoById(@PathVariable("id") Long id) {
        try {
            Empleado empleado = crudRepo.findById(id).get();
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<Void> deleteEmpdoById(@PathVariable("id") Long id) {
        try {
            crudRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empleado")
    public ResponseEntity<Empleado> updateEmpdo(@RequestBody Empleado empleado) {
        Empleado empdo = crudRepo.save(empleado);
        return new ResponseEntity<>(empdo, HttpStatus.CREATED);
    }
}
