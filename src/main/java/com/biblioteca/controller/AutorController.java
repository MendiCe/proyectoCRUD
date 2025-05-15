package com.biblioteca.controller;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.dto.LibroDTO;
import com.biblioteca.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> crearAutor(@RequestBody AutorDTO autorDTO) {
        return ResponseEntity.ok(autorService.crearAutor(autorDTO));
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> obtenerTodosAutores() {
        return ResponseEntity.ok(autorService.obtenerTodosAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obtenerAutorPorId(@PathVariable Long id) {
        AutorDTO autor = autorService.obtenerAutorPorId(id);
        return (autor != null) ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/libros")
    public ResponseEntity<List<LibroDTO>> obtenerLibrosPorAutor(@PathVariable Long id) {
        List<LibroDTO> libros = autorService.obtenerLibrosPorAutor(id);
        return ResponseEntity.ok(libros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        AutorDTO actualizado = autorService.actualizarAutor(id, autorDTO);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return ResponseEntity.noContent().build();
    }
}