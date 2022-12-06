package br.edu.utfpr.melodyGenerator.controller;

import br.edu.utfpr.melodyGenerator.service.GeneratedMelodyService;
import br.edu.utfpr.melodyGenerator.service.impl.GeneratedMelodyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("top10")
public class Top10Controller {

    @Autowired
    GeneratedMelodyService generatedMelodyService;

    @Autowired
    GeneratedMelodyServiceImpl generatedMelodyServiceImpl;

    @GetMapping
    public String top10(Model model) {
        model.addAttribute("melodias", generatedMelodyServiceImpl.findGeneratedMelodyByGrade());

        return "top10.html";
    }
}
