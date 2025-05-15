package com.biblioteca.service;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.dto.LibroDTO;

import java.util.List;

public interface AutorService {
    AutorDTO crearAutor(AutorDTO autorDTO);
    List<AutorDTO> obtenerTodosAutores();
    AutorDTO obtenerAutorPorId(Long id);
    List<LibroDTO> obtenerLibrosPorAutor(Long autorId);
    AutorDTO actualizarAutor(Long id, AutorDTO autorDTO);
    void eliminarAutor(Long id);
}