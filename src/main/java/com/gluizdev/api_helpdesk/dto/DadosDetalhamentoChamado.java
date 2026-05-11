package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.enums.PrioridadeChamado;
import com.gluizdev.api_helpdesk.enums.StatusChamado;
import com.gluizdev.api_helpdesk.model.Chamado;

import java.time.LocalDateTime;

public record DadosDetalhamentoChamado(
        Long id,
        String titulo,
        String descricao,
        StatusChamado status,
        PrioridadeChamado prioridade,
        String nomeUsuario,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao
) {

    public DadosDetalhamentoChamado(Chamado chamado) {
        this(
                chamado.getId(),
                chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getStatus(),
                chamado.getPrioridade(),
                chamado.getUsuario().getNome(),
                chamado.getDataCriacao(),
                chamado.getDataAtualizacao()
        );
    }
}