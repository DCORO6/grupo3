package com.ejercicio.grupo3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PintorService {

    @Autowired
    private PintorRepository pintorRepository;

    public List<Pintor> findAll() {
        return pintorRepository.findAll();
    }

    public Optional<Pintor> findById(Long id) {
        return pintorRepository.findById(id);
    }

    public Pintor save(Pintor pintor) {
        return pintorRepository.save(pintor);
    }

    public void deleteById(Long id) {
        pintorRepository.deleteById(id);
    }
}
