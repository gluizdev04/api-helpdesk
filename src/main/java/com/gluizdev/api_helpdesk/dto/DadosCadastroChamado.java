package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.enums.PrioridadeChamado;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroChamado(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        PrioridadeChamado prioridade,
        @NotBlank
        Long idUsuario
) {
}
