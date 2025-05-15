package com.biblioteca.controller;

import com.biblioteca.dto.PrestamoDTO;
import com.biblioteca.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<PrestamoDTO> crearPrestamo(@RequestBody PrestamoDTO prestamoDTO) {
        PrestamoDTO nuevoPrestamo = prestamoService.crearPrestamo(prestamoDTO);
        return (nuevoPrestamo != null) ? ResponseEntity.ok(nuevoPrestamo) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> obtenerTodosPrestamos() {
        return ResponseEntity.ok(prestamoService.obtenerTodosPrestamos());
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<PrestamoDTO>> obtenerPrestamosPorUsuario(@PathVariable String usuario) {
        List<PrestamoDTO> prestamos = prestamoService.obtenerPrestamosPorUsuario(usuario);
        return ResponseEntity.ok(prestamos);
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<PrestamoDTO> marcarComoDevuelto(@PathVariable Long id) {
        PrestamoDTO prestamoActualizado = prestamoService.marcarComoDevuelto(id);
        return (prestamoActualizado != null) ? ResponseEntity.ok(prestamoActualizado) : ResponseEntity.notFound().build();
    }
}