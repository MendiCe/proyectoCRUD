package com.biblioteca.service.impl;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.dto.LibroDTO;
import com.biblioteca.entity.Autor;
import com.biblioteca.entity.Libro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.AutorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public AutorDTO crearAutor(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNombre(autorDTO.getNombre());
        autor.setNacionalidad(autorDTO.getNacionalidad());
        autor.setFechaNacimiento(autorDTO.getFechaNacimiento());

        Autor autorGuardado = autorRepository.save(autor);
        autorDTO.setId(autorGuardado.getId());
        return autorDTO;
    }

    @Override
    public List<AutorDTO> obtenerTodosAutores() {
        return autorRepository.findAll().stream().map(autor -> {
            AutorDTO dto = new AutorDTO();
            dto.setId(autor.getId());
            dto.setNombre(autor.getNombre());
            dto.setNacionalidad(autor.getNacionalidad());
            dto.setFechaNacimiento(autor.getFechaNacimiento());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public AutorDTO obtenerAutorPorId(Long id) {
        return autorRepository.findById(id).map(autor -> {
            AutorDTO dto = new AutorDTO();
            dto.setId(autor.getId());
            dto.setNombre(autor.getNombre());
            dto.setNacionalidad(autor.getNacionalidad());
            dto.setFechaNacimiento(autor.getFechaNacimiento());
            return dto;
        }).orElse(null);
    }

    @Override
    public List<LibroDTO> obtenerLibrosPorAutor(Long autorId) {
        return libroRepository.findAll().stream()
                .filter(libro -> libro.getAutor().getId().equals(autorId))
                .map(libro -> {
                    LibroDTO libroDTO = new LibroDTO();
                    libroDTO.setId(libro.getId());
                    libroDTO.setTitulo(libro.getTitulo());
                    libroDTO.setIsbn(libro.getIsbn());
                    libroDTO.setGenero(libro.getGenero());
                    libroDTO.setAnioPublicacion(libro.getAnioPublicacion());
                    libroDTO.setAutorId(libro.getAutor().getId());
                    return libroDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public AutorDTO actualizarAutor(Long id, AutorDTO autorDTO) {
        return autorRepository.findById(id).map(autor -> {
            autor.setNombre(autorDTO.getNombre());
            autor.setNacionalidad(autorDTO.getNacionalidad());
            autor.setFechaNacimiento(autorDTO.getFechaNacimiento());
            Autor autorActualizado = autorRepository.save(autor);
            autorDTO.setId(autorActualizado.getId());
            return autorDTO;
        }).orElse(null);
    }

    @Override
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }
}