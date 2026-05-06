package com.gluizdev.api_helpdesk.controller;

import com.gluizdev.api_helpdesk.dto.DadosCadastroUsuario;
import com.gluizdev.api_helpdesk.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario) {
        usuarioService.cadastrarUsuario(dadosCadastroUsuario);
    }
}
