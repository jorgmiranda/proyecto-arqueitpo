package com.ejemplo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;
    @Column(name = "titulo_libro")
    private String titulo;
    @Column(name = "autor_libro")
    private String autor;
    @Column(name = "year_libro")
    private int yearPublicacion;
    @Column(name = "genero_libro")
    private String genero;
    
    public Libro() {
    }

    public Libro(Long id, String titulo, String autor, int yearPublicacion, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.yearPublicacion = yearPublicacion;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYearPublicacion() {
        return yearPublicacion;
    }

    public void setYearPublicacion(int yearPublicacion) {
        this.yearPublicacion = yearPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    

}
