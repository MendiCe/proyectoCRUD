package com.biblioteca.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AutorDTO {
    private Long id;
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
}
