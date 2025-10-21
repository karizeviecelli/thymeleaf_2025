// src/main/java/.../controller/UsuarioController.java
package com.lojaaviamentos.aviamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lojaaviamentos.aviamentos.domain.Usuario;
import com.lojaaviamentos.aviamentos.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

   // LISTA (apenas /usuarios)
@GetMapping("/usuarios")
public String listarUsuarios(Model model) {
    model.addAttribute("usuarios", service.listAll()); // <- NOME DO ATRIBUTO
    return "list";
}

    // Formulário
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form"; // templates/form.html
    }

    
// SALVAR → volta pra /usuarios
@PostMapping("/usuario")
public String salvar(@ModelAttribute("usuario") Usuario usuario) {
    service.save(usuario);
    return "redirect:/usuarios";
}
}
