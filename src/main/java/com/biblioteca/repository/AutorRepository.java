package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
