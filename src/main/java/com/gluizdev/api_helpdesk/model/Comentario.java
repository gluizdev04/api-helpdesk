package com.gluizdev.api_helpdesk.model;

import com.gluizdev.api_helpdesk.dto.DadosAtualizarComentario;
import com.gluizdev.api_helpdesk.dto.DadosCadastroComentario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Comentario")
@Table(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "chamado_id", nullable = false)
    private Chamado chamado;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Comentario(DadosCadastroComentario dadosCadastroComentario) {
        this.texto = dadosCadastroComentario.texto();
    }

    public void atualizarDados(DadosAtualizarComentario dadosAtualizarComentario) {
        if (dadosAtualizarComentario.texto() != null) {
            this.texto = dadosAtualizarComentario.texto();
        }
    }
}
