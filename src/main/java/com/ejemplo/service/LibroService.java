package com.ejemplo.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo.model.Libro;

public interface LibroService {
    List<Libro> getAllLibros();
    Optional <Libro> getLibroByID(Long id);
    Libro crearLibro(Libro libro);
    Libro actualizarLibro(Long id, Libro libro);
    void eliminarLibro(Long id);
}
