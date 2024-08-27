package com.ejercicio.grupo3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuadroService {

    @Autowired
    private CuadroRepository cuadroRepository;

    public List<Cuadro> findAll() {
        return cuadroRepository.findAll();
    }

    public Optional<Cuadro> findById(Long id) {
        return cuadroRepository.findById(id);
    }

    public Cuadro save(Cuadro cuadro) {
        return cuadroRepository.save(cuadro);
    }

    public void deleteById(Long id) {
        cuadroRepository.deleteById(id);
    }

}