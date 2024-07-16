package com.alura.ForoAlura.domain.cursos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNombre(String nombre);
}
