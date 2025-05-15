package com.biblioteca.service.impl;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.entity.Autor;
import com.biblioteca.entity.Libro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.LibroService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO) {
        Optional<Autor> autor = autorRepository.findById(libroDTO.getAutorId());
        if (autor.isPresent()) {
            Libro libro = new Libro();
            libro.setTitulo(libroDTO.getTitulo());
            libro.setIsbn(libroDTO.getIsbn());
            libro.setGenero(libroDTO.getGenero());
            libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
            libro.setAutor(autor.get());

            Libro libroGuardado = libroRepository.save(libro);
            libroDTO.setId(libroGuardado.getId());
            return libroDTO;
        }
        return null;
    }

    @Override
    public List<LibroDTO> obtenerTodosLibros() {
        return libroRepository.findAll().stream().map(libro -> {
            LibroDTO dto = new LibroDTO();
            dto.setId(libro.getId());
            dto.setTitulo(libro.getTitulo());
            dto.setIsbn(libro.getIsbn());
            dto.setGenero(libro.getGenero());
            dto.setAnioPublicacion(libro.getAnioPublicacion());
            dto.setAutorId(libro.getAutor().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public LibroDTO obtenerLibroPorId(Long id) {
        return libroRepository.findById(id).map(libro -> {
            LibroDTO dto = new LibroDTO();
            dto.setId(libro.getId());
            dto.setTitulo(libro.getTitulo());
            dto.setIsbn(libro.getIsbn());
            dto.setGenero(libro.getGenero());
            dto.setAnioPublicacion(libro.getAnioPublicacion());
            dto.setAutorId(libro.getAutor().getId());
            return dto;
        }).orElse(null);
    }

    @Override
    public LibroDTO actualizarLibro(Long id, LibroDTO libroDTO) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDTO.getTitulo());
            libro.setIsbn(libroDTO.getIsbn());
            libro.setGenero(libroDTO.getGenero());
            libro.setAnioPublicacion(libroDTO.getAnioPublicacion());

            Libro libroActualizado = libroRepository.save(libro);
            libroDTO.setId(libroActualizado.getId());
            return libroDTO;
        }).orElse(null);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}