package com.gluizdev.api_helpdesk.service;

import com.gluizdev.api_helpdesk.dto.DadosAtualizarUsuario;
import com.gluizdev.api_helpdesk.dto.DadosCadastroUsuario;
import com.gluizdev.api_helpdesk.dto.DadosDetalhamentoUsuario;
import com.gluizdev.api_helpdesk.dto.DadosListagemUsuarios;
import com.gluizdev.api_helpdesk.model.Usuario;
import com.gluizdev.api_helpdesk.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(DadosCadastroUsuario dadosCadastroUsuarioUsuario) {
        Usuario usuario = new Usuario(dadosCadastroUsuarioUsuario);
        return usuarioRepository.save(usuario);
    }

    public Page<DadosListagemUsuarios> exibirUsuarios(Pageable paginacao) {
        return usuarioRepository.findAll(paginacao).map(DadosListagemUsuarios::new);
    }

    public Usuario atualizarUsuario(DadosAtualizarUsuario dadosAtualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(dadosAtualizarUsuario.id());
        usuario.alterarDados(dadosAtualizarUsuario);
        return usuario;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.delete(usuarioRepository.getReferenceById(id));
    }

    public DadosDetalhamentoUsuario buscarPorId(Long id) {
        var usuario = usuarioRepository.getReferenceById(id);
        return new DadosDetalhamentoUsuario(usuario);
    }
}
