package br.edu.utfpr.melodyGenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"", "index.html"})
    public String index(Model model) {
        return "index.html";
    }

    @GetMapping("gerarMelodia.html")
    public String gerarMelodia(Model model) {
        return "gerarMelodia.html";
    }

    @GetMapping("top10.html")
    public String top10(Model model) {
        return "top10.html";
    }
}
