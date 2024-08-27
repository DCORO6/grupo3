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
@RequestMapping("/cuadros")
public class CuadroController {

    @Autowired
    private CuadroService cuadroService;

    @GetMapping
    public List<Cuadro> getAllCuadros() {
        return cuadroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuadro> getCuadroById(@PathVariable Long id) {
        Optional<Cuadro> cuadro = cuadroService.findById(id);
        return cuadro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuadro createCuadro(@RequestBody Cuadro cuadro) {
        return cuadroService.save(cuadro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuadro> updateCuadro(@PathVariable Long id, @RequestBody Cuadro cuadro) {
        if (cuadroService.findById(id).isPresent()) {
            cuadro.setId(id);
            return ResponseEntity.ok(cuadroService.save(cuadro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuadro(@PathVariable Long id) {
        if (cuadroService.findById(id).isPresent()) {
            cuadroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
