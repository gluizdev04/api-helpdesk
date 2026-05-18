package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.model.Comentario;

import java.time.LocalDateTime;

public record DadosListagemComentarios(
        Long id,
        String texto,
        String chamado,
        String usuario,
        LocalDateTime dataCriacao
) {
    public DadosListagemComentarios(Comentario comentario) {
        this(
                comentario.getId(),
                comentario.getTexto(),
                comentario.getChamado().getTitulo(),
                comentario.getUsuario().getNome(),
                comentario.getDataCriacao()
        );
    }
}
