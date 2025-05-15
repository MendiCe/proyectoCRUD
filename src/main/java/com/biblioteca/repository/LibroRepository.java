package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
