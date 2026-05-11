package com.gluizdev.api_helpdesk.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(@NotNull Long id,
                                    String nome,
                                    String email,
                                    String senha) {
}
