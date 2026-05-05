package com.gluizdev.api_helpdesk.model;

import com.gluizdev.api_helpdesk.enums.PrioridadeChamado;
import com.gluizdev.api_helpdesk.enums.StatusChamado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Chamado")
@Table(name = "chamados")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusChamado status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PrioridadeChamado prioridade;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "chamado")
    private List<Comentario> comentarios;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
