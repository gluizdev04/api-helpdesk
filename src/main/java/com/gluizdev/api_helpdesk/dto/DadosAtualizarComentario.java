package com.gluizdev.api_helpdesk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarComentario(
        @NotNull
        Long id,
        @NotBlank
        String texto) {
}
