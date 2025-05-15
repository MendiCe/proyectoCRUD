package com.biblioteca.entity;

import com.biblioteca.enums.Genero;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private int anioPublicacion;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}