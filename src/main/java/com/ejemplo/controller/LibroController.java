package com.ejemplo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ejemplo.model.Libro;
import com.ejemplo.service.LibroService;


@RestController
@RequestMapping("/libros")
public class LibroController {
    private static final Logger log = LoggerFactory.getLogger(LibroController.class);

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibros(){
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLibroByID(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroByID(id);
        if(libro.isEmpty()){
            log.error("No se encontro ningun Libro con ese ID {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro ningun Libro con ese ID"));
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Object> crearRol(@RequestBody Libro libro){
        
        Libro librocreado = new Libro();
        librocreado.setTitulo(libro.getTitulo());
        librocreado.setAutor(libro.getAutor());
        librocreado.setGenero(libro.getGenero());
        librocreado.setYearPublicacion(libro.getYearPublicacion());

        Libro r = libroService.crearLibro(librocreado);
        if(r == null){
            log.error("Error al crear el libro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al crear el libro"));
        }
        return ResponseEntity.ok(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarRol(@PathVariable Long id, @RequestBody Libro libro){
        Optional<Libro> librobuscado = libroService.getLibroByID(id);
        if(librobuscado.isEmpty()){
            log.error("No se encontro ningun Libro con ese ID {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro ningun rol con ese ID"));
        }
        
        Libro l = new Libro();
        l.setTitulo(libro.getTitulo());
        l.setAutor(libro.getAutor());
        l.setGenero(libro.getGenero());
        l.setYearPublicacion(libro.getYearPublicacion());
                
        Libro retorno = libroService.actualizarLibro(id, l);
        return ResponseEntity.ok(retorno);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarLibro(@PathVariable Long id){
        Optional<Libro> librobuscado = libroService.getLibroByID(id);
        if(librobuscado.isEmpty()){
            log.error("No se encontro ningun Libro con ese ID {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro ningun Libro con ese ID"));
        }

        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro Eliminado");
    }

    static class ErrorResponse {
        private final String message;
    
        public ErrorResponse(String message){
            this.message = message;
        }
    
        public String getMessage(){
            return message;
        }
        
    }
}
