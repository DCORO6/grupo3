package com.ejercicio.grupo3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Cuadro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int ano;

    @ManyToOne
    private Pintor pintor;

    // Getters y Setters
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

    public int getAnio() {
        return ano;
    }

    public void setAnio(int anio) {
        this.ano = anio;
    }

    public Pintor getPintor() {
        return pintor;
    }

    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

   
}


