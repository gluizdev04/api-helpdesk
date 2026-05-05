package com.gluizdev.api_helpdesk.model;

import com.gluizdev.api_helpdesk.enums.PerfilUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Chamado> chamados;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfil;

    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }
}
