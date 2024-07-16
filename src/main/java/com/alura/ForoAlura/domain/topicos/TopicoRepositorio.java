package com.alura.ForoAlura.domain.topicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicoRepositorio extends JpaRepository<Topico, Integer> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
