package com.gluizdev.api_helpdesk.controller;

import com.gluizdev.api_helpdesk.dto.DadosAtualizarUsuario;
import com.gluizdev.api_helpdesk.dto.DadosCadastroUsuario;
import com.gluizdev.api_helpdesk.dto.DadosDetalhamentoUsuario;
import com.gluizdev.api_helpdesk.dto.DadosListagemUsuarios;
import com.gluizdev.api_helpdesk.model.Usuario;
import com.gluizdev.api_helpdesk.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario,
                                                                     UriComponentsBuilder uriBuilder) {
        Usuario usuario = usuarioService.cadastrarUsuario(dadosCadastroUsuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarios>> exibirUsuarios(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = usuarioService.exibirUsuarios(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarUsuario(@RequestBody DadosAtualizarUsuario dadosAtualizarUsuario) {
        var usuario = usuarioService.atualizarUsuario(dadosAtualizarUsuario);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuarioPorId(@PathVariable Long id) {
        var usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }
}
