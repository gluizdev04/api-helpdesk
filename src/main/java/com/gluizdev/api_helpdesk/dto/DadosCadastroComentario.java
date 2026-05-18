package com.gluizdev.api_helpdesk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroComentario(
        @NotBlank
        String texto,
        @NotNull
        Long chamadoId,
        @NotNull
        Long usuarioId
) {
}
