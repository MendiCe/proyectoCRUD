package com.biblioteca.dto;

import lombok.Data;
import com.biblioteca.enums.Genero;

@Data
public class LibroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private Genero genero;
    private int anioPublicacion;
    private Long autorId;
}