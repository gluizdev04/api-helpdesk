package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.enums.PrioridadeChamado;
import com.gluizdev.api_helpdesk.enums.StatusChamado;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarChamado(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        StatusChamado status,
        PrioridadeChamado prioridade
) {
}