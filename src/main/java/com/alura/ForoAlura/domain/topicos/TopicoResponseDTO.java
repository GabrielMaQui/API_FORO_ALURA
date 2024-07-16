package com.alura.ForoAlura.domain.topicos;

import java.time.LocalDateTime;

public record TopicoResponseDTO(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion) {
}
