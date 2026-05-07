package com.gluizdev.api_helpdesk.repository;

import com.gluizdev.api_helpdesk.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
