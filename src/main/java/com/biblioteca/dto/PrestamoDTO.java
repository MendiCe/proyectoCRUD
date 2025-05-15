package com.biblioteca.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PrestamoDTO {
    private Long id;
    private String usuario;
    private Long libroId;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
}