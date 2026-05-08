package com.gluizdev.api_helpdesk.dto;

import com.gluizdev.api_helpdesk.enums.PerfilUsuario;
import com.gluizdev.api_helpdesk.model.Usuario;

import java.time.LocalDateTime;

public record DadosListagemUsuarios(Long id,
                                    String nome,
                                    String email,
                                    PerfilUsuario perfil,
                                    LocalDateTime dataCriacao) {

    public DadosListagemUsuarios(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPerfil(),
                usuario.getDataCriacao()
        );
    }
}
