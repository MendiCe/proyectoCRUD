package com.biblioteca.service;

import com.biblioteca.dto.PrestamoDTO;
import java.util.List;

public interface PrestamoService {
    PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO);
    List<PrestamoDTO> obtenerTodosPrestamos();
    List<PrestamoDTO> obtenerPrestamosPorUsuario(String usuario);
    PrestamoDTO marcarComoDevuelto(Long prestamoId);
}