package br.edu.utfpr.melodyGenerator.controller;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import br.edu.utfpr.melodyGenerator.model.UserFeedback;
import br.edu.utfpr.melodyGenerator.service.UserFeedbackService;
import br.edu.utfpr.melodyGenerator.service.impl.GeneratedMelodyServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
@RequestMapping("generatedMelody")
public class GeneratedMelodyController {

    @Autowired
    private UserFeedbackService userFeedbackService;

    @Autowired
    private GeneratedMelodyServiceImpl generatedMelodyService;

    @GetMapping(value = { ""})
    public String generatedMelody(Model model) {
        model.addAttribute("userFeedback", new UserFeedback());
        model.addAttribute("generatedMelody", generatedMelodyService.findMaxGeneratedMelody());

        return "generatedMelody.html";
    }
/*
    @PostMapping
    public ResponseEntity player(@Valid UserFeedback userFeedback) {

        userFeedback.setDate_hour(new Timestamp(System.currentTimeMillis()));

        GeneratedMelody generatedMelody = generatedMelodyService.findMaxGeneratedMelody();
        if(userFeedback.getGrade() == null){
            userFeedback.setGrade(0);
        }
        if(userFeedback.getImprovement_suggestion().equals(null)){
            userFeedback.setImprovement_suggestion("");
        }
        userFeedback.setMelody_id(generatedMelody);

        userFeedbackService.save(userFeedback);

        return new ResponseEntity(HttpStatus.OK);
    }*/

    @PostMapping
    public void player(HttpServletRequest request) {

        String grade = request.getParameter("grade");
        String improvement_suggestion = request.getParameter("improvement_suggestion");

        UserFeedback userFeedback = new UserFeedback();

        if(grade == null){
            grade = "0";
        }
        if(improvement_suggestion == null){
            userFeedback.setImprovement_suggestion("");
        }
        userFeedback.setDate_hour(new Timestamp(System.currentTimeMillis()));
        userFeedback.setGrade(Integer.valueOf(grade));
        userFeedback.setImprovement_suggestion(improvement_suggestion);
        GeneratedMelody generatedMelody = generatedMelodyService.findMaxGeneratedMelody();
        userFeedback.setMelody_id(generatedMelody);

        userFeedbackService.save(userFeedback);
    }
}