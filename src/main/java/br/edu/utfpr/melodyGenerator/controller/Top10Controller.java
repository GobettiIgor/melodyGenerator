package br.edu.utfpr.melodyGenerator.controller;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import br.edu.utfpr.melodyGenerator.model.UserFeedback;
import br.edu.utfpr.melodyGenerator.service.impl.GeneratedMelodyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("top10")
public class Top10Controller {

    @Autowired
    GeneratedMelodyServiceImpl generatedMelodyServiceImpl;

    @GetMapping(value = {""})
    public String top10() {

        return "top10.html";
    }

    @PostMapping
    public String player(@Valid UserFeedback feedback,
                         BindingResult result,
                         Model model,
                         RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("feedback", feedback);
            return "melodyParameter/form";
        }

        attributes.addFlashAttribute("sucesso",
                "Feedback enviado com sucesso!");
        return "redirect:/generatedMelody";
    }
}
