package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.enums.PrioridadeChamado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroChamado(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotNull
        PrioridadeChamado prioridade,
        @NotNull
        Long idUsuario
) {
}
