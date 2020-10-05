package com.contoso.eventos.eventos.controller;

import com.contoso.eventos.eventos.model.Evento;
import com.contoso.eventos.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping("/lista")
    public String listarEventos(Model model) {

        model.addAttribute("lstEventos", service.listarTodos());
        return "lista";
    }

    @GetMapping(value = "/novo")
    public String novoGet(@ModelAttribute Evento evento, Model model) {
        return "novo";
    }

    @PostMapping("/novo")
    public String novoPost(@ModelAttribute Evento evento, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "";
        }

        service.salvar(evento);
        return "redirect:/eventos/lista";
    }

    @GetMapping(value = "/editar/{id}")
    public String editarGet(@PathVariable long id, Model model) {
        model.addAttribute("evento", service.buscarPorId(id));
        return "editar";
    }

    @PostMapping("/editar")
    public String editarPost(@ModelAttribute Evento evento, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "";
        }

        service.salvar(evento);
        return "redirect:/eventos/lista";
    }


    @GetMapping("/excluir/{id}")
    public String excluirPost(@PathVariable long id) {

        service.excluir(id);
        return "redirect:/eventos/lista";
    }
}
