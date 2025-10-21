
    package com.lojaaviamentos.aviamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // manda a raiz para a lista
    @GetMapping("/")
    public String home() {
        return "redirect:/usuarios"; // precisa existir templates/list.html
    }
}


