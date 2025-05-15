package com.biblioteca.controller;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody LibroDTO libroDTO) {
        LibroDTO nuevoLibro = libroService.crearLibro(libroDTO);
        return (nuevoLibro != null) ? ResponseEntity.ok(nuevoLibro) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> obtenerTodosLibros() {
        return ResponseEntity.ok(libroService.obtenerTodosLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id) {
        LibroDTO libro = libroService.obtenerLibroPorId(id);
        return (libro != null) ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        LibroDTO libroActualizado = libroService.actualizarLibro(id, libroDTO);
        return (libroActualizado != null) ? ResponseEntity.ok(libroActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}