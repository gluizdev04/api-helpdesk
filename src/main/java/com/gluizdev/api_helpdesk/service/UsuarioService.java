package com.gluizdev.api_helpdesk.service;

import com.gluizdev.api_helpdesk.dto.DadosCadastroUsuario;
import com.gluizdev.api_helpdesk.model.Usuario;
import com.gluizdev.api_helpdesk.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrarUsuario(DadosCadastroUsuario dadosCadastroUsuarioUsuario) {
        Usuario usuario = new Usuario(dadosCadastroUsuarioUsuario);
        usuarioRepository.save(usuario);
    }
}
