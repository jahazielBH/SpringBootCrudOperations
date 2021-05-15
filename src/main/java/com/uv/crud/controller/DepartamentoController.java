/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uv.crud.controller;

import com.uv.crud.model.Departamento;
import com.uv.crud.repository.DepartamentoCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jahaziel
 */
@RestController
@RequestMapping("/api/v1/crud")
public class DepartamentoController {

    @Autowired
    private DepartamentoCrudRepo crudRepo;

    @PostMapping("/departamento")
    public ResponseEntity<Departamento> addDepto(@RequestBody Departamento departamento) {
        try {
            Departamento depto = crudRepo.save(departamento);
            return new ResponseEntity<>(depto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/departamento")
    public ResponseEntity<List<Departamento>> getAllDeptos() {
        try {
            List<Departamento> departamentos = crudRepo.findAll();
            if (departamentos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departamentos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<Departamento> getDeptoById(@PathVariable("id") Long id) {
        try {
            Departamento departamento = crudRepo.findById(id).get();
            return new ResponseEntity<>(departamento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/departamento/{id}")
    public ResponseEntity<Void> deleteDeptoById(@PathVariable("id") Long id) {
        try {
            crudRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/departamento")
    public ResponseEntity<Departamento> updateDepto(@RequestBody Departamento departamento) {
        Departamento depto = crudRepo.save(departamento);
        return new ResponseEntity<>(depto, HttpStatus.CREATED);
    }
}
