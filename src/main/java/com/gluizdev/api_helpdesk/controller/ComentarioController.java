package com.gluizdev.api_helpdesk.controller;

import com.gluizdev.api_helpdesk.dto.DadosAtualizarComentario;
import com.gluizdev.api_helpdesk.dto.DadosCadastroComentario;
import com.gluizdev.api_helpdesk.dto.DadosDetalhamentoComentario;
import com.gluizdev.api_helpdesk.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    private ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoComentario> cadastrarComentario(@RequestBody @Valid DadosCadastroComentario dadosCadastroComentario,
                                                                           UriComponentsBuilder uriBuilder) {
        var comentario = comentarioService.cadastrarComentario(dadosCadastroComentario);
        var uri = uriBuilder.path("/{id}").buildAndExpand(comentario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoComentario(comentario));
    }

    @GetMapping
    public ResponseEntity exibirComentarios(Pageable paginacao) {
        var page = comentarioService.mostrarComentarios(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarComentario(@RequestBody @Valid DadosAtualizarComentario dadosAtualizarComentario) {
        var comentario = comentarioService.atualizarComentario(dadosAtualizarComentario);
        return ResponseEntity.ok(new DadosDetalhamentoComentario(comentario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarComentario(@PathVariable Long id) {
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity comentarioPorId(@PathVariable Long id) {
        var comentario = comentarioService.buscarComentarioPorId(id);
        return ResponseEntity.ok(new DadosDetalhamentoComentario(comentario));
    }
}
