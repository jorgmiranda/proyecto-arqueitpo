package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long>{
    
}
