package com.gluizdev.api_helpdesk.repository;

import com.gluizdev.api_helpdesk.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Long, Comentario> {
}
