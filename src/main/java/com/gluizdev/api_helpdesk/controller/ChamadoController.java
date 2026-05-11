package com.gluizdev.api_helpdesk.controller;

import com.gluizdev.api_helpdesk.dto.DadosCadastroChamado;
import com.gluizdev.api_helpdesk.dto.DadosDetalhamentoChamado;
import com.gluizdev.api_helpdesk.service.ChamadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity cadastrarChamado(@RequestBody DadosCadastroChamado dadosCadastroChamado, UriComponentsBuilder uriBulder) {
        var chamado = chamadoService.cadastrarChamado(dadosCadastroChamado);
        var uri = uriBulder.path("/chamado/{id}").buildAndExpand(chamado.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoChamado(chamado));
    }
}
