package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.model.Usuario;

public record DadosDetalhamentoUsuario(Long id,
                                       String nome,
                                       String email) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
