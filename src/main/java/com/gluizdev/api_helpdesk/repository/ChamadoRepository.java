package com.gluizdev.api_helpdesk.repository;

import com.gluizdev.api_helpdesk.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}
