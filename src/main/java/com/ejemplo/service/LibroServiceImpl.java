package com.ejemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.model.Libro;
import com.ejemplo.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> getLibroByID(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        if (libroRepository.existsById(id)) {
            libro.setId(id);
            return libroRepository.save(libro);
        }else{
            return null;
        }
    }

    @Override
    public void eliminarLibro(Long id) {
       libroRepository.deleteById(id);
    }

    
}
