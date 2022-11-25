package br.edu.utfpr.melodyGenerator.controller;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import br.edu.utfpr.melodyGenerator.model.MelodyParameter;
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
@RequestMapping("generatedMelody")
public class GeneratedMelodyController {

    @Autowired
    GeneratedMelodyServiceImpl generatedMelodyServiceImpl;

    String link = "http://127.0.0.1:8887/Audio";

    @GetMapping(value = { ""})
    public String generatedMelody(Model model) {
        model.addAttribute("userFeedback", new UserFeedback());

        return "generatedMelody.html";
    }

    @PostMapping
    public String player(@Valid UserFeedback userFeedback,
                         BindingResult result,
                         Model model,
                         RedirectAttributes attributes) {

        return "redirect:/generatedMelody";
    }
}
