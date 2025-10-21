package com.lojaaviamentos.aviamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lojaaviamentos.aviamentos.domain.Usuario;
import com.lojaaviamentos.aviamentos.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /** Lista usuários na página inicial */
    @GetMapping({"/", "/usuarios"})
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listAll());
        return "list";
    }

    /** Exibe formulário de cadastro */
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    /** Recebe o POST do formulário e salva */
    @PostMapping("/usuario")
    public String salvar(@ModelAttribute("usuario") Usuario usuario) {
        service.save(usuario);
        return "redirect:/";
    }
}
