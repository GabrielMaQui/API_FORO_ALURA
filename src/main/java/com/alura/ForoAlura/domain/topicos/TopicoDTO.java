package com.alura.ForoAlura.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record TopicoDTO(
        @NotNull String titulo,
        @NotNull String mensaje,
        @NotNull Long usuarioId,
        @NotNull String nombreCurso) {
}
