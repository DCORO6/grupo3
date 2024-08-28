package com.ejercicio.grupo3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pintores")
public class PintorController {

    @Autowired
    private PintorService pintorService;

    @GetMapping
    public List<Pintor> getAllPintores() {
        return pintorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pintor> getPintorById(@PathVariable Long id) {
        Optional<Pintor> pintor = pintorService.findById(id);
        return pintor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pintor createPintor(@RequestBody Pintor pintor) {
        return pintorService.save(pintor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pintor> updatePintor(@PathVariable Long id, @RequestBody Pintor pintor) {
        if (pintorService.findById(id).isPresent()) {
            pintor.setId(id);
            return ResponseEntity.ok(pintorService.save(pintor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePintor(@PathVariable Long id) {
        if (pintorService.findById(id).isPresent()) {
            pintorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
