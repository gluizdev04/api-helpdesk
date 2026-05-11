package com.gluizdev.api_helpdesk.service;

import com.gluizdev.api_helpdesk.dto.DadosCadastroChamado;
import com.gluizdev.api_helpdesk.model.Chamado;
import com.gluizdev.api_helpdesk.repository.ChamadoRepository;
import com.gluizdev.api_helpdesk.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    private ChamadoRepository chamadoRepository;
    private UsuarioRepository usuarioRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, UsuarioRepository usuarioRepository) {
        this.chamadoRepository = chamadoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Chamado cadastrarChamado(DadosCadastroChamado dto) {
        var usuarioEncontrado = usuarioRepository.findById(dto.idUsuario()).orElseThrow();
        var chamado = new Chamado(dto);
        chamado.setUsuario(usuarioEncontrado);
        return chamadoRepository.save(chamado);
    }
}
