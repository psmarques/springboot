package com.contoso.eventos.eventos.service;

import com.contoso.eventos.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoDao extends JpaRepository<Evento, Long>
{

}