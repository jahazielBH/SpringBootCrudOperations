/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uv.crud.repository;

import com.uv.crud.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jahaziel
 */
public interface DepartamentoCrudRepo extends JpaRepository<Departamento, Long> {
    
}
