package com.gluizdev.api_helpdesk.service;

import com.gluizdev.api_helpdesk.dto.DadosAtualizarComentario;
import com.gluizdev.api_helpdesk.dto.DadosCadastroComentario;
import com.gluizdev.api_helpdesk.dto.DadosListagemComentarios;
import com.gluizdev.api_helpdesk.model.Comentario;
import com.gluizdev.api_helpdesk.repository.ChamadoRepository;
import com.gluizdev.api_helpdesk.repository.ComentarioRepository;
import com.gluizdev.api_helpdesk.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private ComentarioRepository comentarioRepository;
    private UsuarioRepository usuarioRepository;
    private ChamadoRepository chamadoRepository;

    public ComentarioService(UsuarioRepository usuarioRepository,
                             ChamadoRepository chamadoRepository,
                             ComentarioRepository comentarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.chamadoRepository = chamadoRepository;
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario cadastrarComentario(DadosCadastroComentario dadosCadastroComentario) {
        var comentario = new Comentario(dadosCadastroComentario);

        var usuario = usuarioRepository.getReferenceById(dadosCadastroComentario.usuarioId());
        var chamado = chamadoRepository.getReferenceById(dadosCadastroComentario.chamadoId());

        comentario.setUsuario(usuario);
        comentario.setChamado(chamado);

        return comentarioRepository.save(comentario);
    }

    public Page<DadosListagemComentarios> mostrarComentarios(Pageable paginacao) {
        return comentarioRepository.findAll(paginacao).map(DadosListagemComentarios::new);
    }

    public Comentario atualizarComentario(DadosAtualizarComentario dadosAtualizarComentario) {
        var comentario = comentarioRepository.getReferenceById(dadosAtualizarComentario.id());
        comentario.atualizarDados(dadosAtualizarComentario);
        return comentario;
    }

    public void deletarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    public Comentario buscarComentarioPorId(Long id) {
        return comentarioRepository.getReferenceById(id);
    }
}
