package com.gluizdev.api_helpdesk.controller;

import com.gluizdev.api_helpdesk.dto.DadosAtualizarChamado;
import com.gluizdev.api_helpdesk.dto.DadosCadastroChamado;
import com.gluizdev.api_helpdesk.dto.DadosDetalhamentoChamado;
import com.gluizdev.api_helpdesk.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/chamado")
public class ChamadoController {

    private ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarChamado(@RequestBody @Valid DadosCadastroChamado dadosCadastroChamado, UriComponentsBuilder uriBulder) {
        var chamado = chamadoService.cadastrarChamado(dadosCadastroChamado);
        var uri = uriBulder.path("/chamado/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoChamado(chamado));
    }

    @GetMapping
    public ResponseEntity exibirChamado(Pageable paginacao) {
        var page = chamadoService.exibirUsuarios(paginacao);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizarChamado(@RequestBody @Valid DadosAtualizarChamado dadosAtualizarChamado) {
        var chamado = chamadoService.atualizarChamado(dadosAtualizarChamado);
        return ResponseEntity.ok(new DadosDetalhamentoChamado(chamado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarChamado(@PathVariable Long id) {
        chamadoService.deletarChamado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity chamadoPorId(@PathVariable Long id) {
        var chamado = chamadoService.chamadoPorId(id);
        return ResponseEntity.ok(chamado);
    }
}
