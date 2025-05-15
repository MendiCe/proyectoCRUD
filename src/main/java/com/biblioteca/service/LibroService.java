package com.biblioteca.service;

import com.biblioteca.dto.LibroDTO;
import java.util.List;

public interface LibroService {
    LibroDTO crearLibro(LibroDTO libroDTO);
    List<LibroDTO> obtenerTodosLibros();
    LibroDTO obtenerLibroPorId(Long id);
    LibroDTO actualizarLibro(Long id, LibroDTO libroDTO);
    void eliminarLibro(Long id);
}