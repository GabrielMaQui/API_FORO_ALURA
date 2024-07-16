package com.alura.ForoAlura.domain.topicos;

import com.alura.ForoAlura.domain.cursos.Curso;
import com.alura.ForoAlura.domain.usuario.UserDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDetalleDTO(
        Long id,
        String titulo,
        String mensaje,
        @NotNull LocalDateTime fechaCreacion,
        UserDTO autor,
        Curso curso
        ) {
}
