package com.alura.ForoAlura.domain.topicos;

import java.time.LocalDateTime;

public record TopicoDTORead(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
}
