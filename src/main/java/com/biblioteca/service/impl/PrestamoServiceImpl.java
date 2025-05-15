package com.biblioteca.service.impl;

import com.biblioteca.dto.PrestamoDTO;
import com.biblioteca.entity.Libro;
import com.biblioteca.entity.Prestamo;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.service.PrestamoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO) {
        Optional<Libro> libro = libroRepository.findById(prestamoDTO.getLibroId());
        if (libro.isPresent()) {
            Prestamo prestamo = new Prestamo();
            prestamo.setUsuario(prestamoDTO.getUsuario());
            prestamo.setLibro(libro.get());
            prestamo.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
            prestamo.setFechaDevolucion(prestamoDTO.getFechaDevolucion());
            prestamo.setDevuelto(false);

            Prestamo prestamoGuardado = prestamoRepository.save(prestamo);
            prestamoDTO.setId(prestamoGuardado.getId());
            return prestamoDTO;
        }
        return null;
    }

    @Override
    public List<PrestamoDTO> obtenerTodosPrestamos() {
        return prestamoRepository.findAll().stream().map(prestamo -> {
            PrestamoDTO dto = new PrestamoDTO();
            dto.setId(prestamo.getId());
            dto.setUsuario(prestamo.getUsuario());
            dto.setLibroId(prestamo.getLibro().getId());
            dto.setFechaPrestamo(prestamo.getFechaPrestamo());
            dto.setFechaDevolucion(prestamo.getFechaDevolucion());
            dto.setDevuelto(prestamo.isDevuelto());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PrestamoDTO> obtenerPrestamosPorUsuario(String usuario) {
        return prestamoRepository.findAll().stream()
                .filter(prestamo -> prestamo.getUsuario().equals(usuario))
                .map(prestamo -> {
                    PrestamoDTO dto = new PrestamoDTO();
                    dto.setId(prestamo.getId());
                    dto.setUsuario(prestamo.getUsuario());
                    dto.setLibroId(prestamo.getLibro().getId());
                    dto.setFechaPrestamo(prestamo.getFechaPrestamo());
                    dto.setFechaDevolucion(prestamo.getFechaDevolucion());
                    dto.setDevuelto(prestamo.isDevuelto());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public PrestamoDTO marcarComoDevuelto(Long prestamoId) {
        return prestamoRepository.findById(prestamoId).map(prestamo -> {
            prestamo.setDevuelto(true);
            Prestamo prestamoActualizado = prestamoRepository.save(prestamo);
            PrestamoDTO dto = new PrestamoDTO();
            dto.setId(prestamoActualizado.getId());
            dto.setUsuario(prestamoActualizado.getUsuario());
            dto.setLibroId(prestamoActualizado.getLibro().getId());
            dto.setFechaPrestamo(prestamoActualizado.getFechaPrestamo());
            dto.setFechaDevolucion(prestamoActualizado.getFechaDevolucion());
            dto.setDevuelto(prestamoActualizado.isDevuelto());
            return dto;
        }).orElse(null);
    }
}