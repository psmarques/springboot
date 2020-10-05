package com.contoso.eventos.eventos.controller;

import com.contoso.eventos.eventos.model.Evento;
import com.contoso.eventos.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage() {

        return "index";
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
