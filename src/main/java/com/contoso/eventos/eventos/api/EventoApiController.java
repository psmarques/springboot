package com.contoso.eventos.eventos.api;

import com.contoso.eventos.eventos.model.Evento;
import com.contoso.eventos.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/evento")
public class EventoApiController {

    @Autowired
    private EventoService service;

    @GetMapping
    public List<Evento> listarTodos() {

        return service.listarTodos();
    }

    @PostMapping
    public Evento inserirNovo(@Valid @NotNull @RequestBody Evento evento) {

        return service.salvar(evento);
    }

    @PutMapping
    public Evento alterar(@Valid @NotNull @RequestBody Evento evento) {

        return service.salvar(evento);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {

        service.excluir(id);
    }


}
