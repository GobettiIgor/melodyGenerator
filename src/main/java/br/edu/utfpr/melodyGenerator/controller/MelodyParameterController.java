package br.edu.utfpr.melodyGenerator.controller;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import br.edu.utfpr.melodyGenerator.model.MelodyParameter;
import br.edu.utfpr.melodyGenerator.model.RandomMelody;
import br.edu.utfpr.melodyGenerator.service.GeneratedMelodyService;
import br.edu.utfpr.melodyGenerator.service.MelodyParameterService;
import br.edu.utfpr.melodyGenerator.service.impl.GenerateMelodyService;
import br.edu.utfpr.melodyGenerator.service.impl.MelodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("generateMelody")
public class MelodyParameterController {

    @Autowired
    private MelodyParameterService melodyParameterService;

    @Autowired
    private GenerateMelodyService generateMelodyService;

    @Autowired
    private GeneratedMelodyService generatedMelodyService;

    @Autowired
    private MelodyService melodyService;

    @GetMapping(value = {""})
    public String generateMelody(Model model, RedirectAttributes attributes) {
        model.addAttribute("melodyParameter", new MelodyParameter());

        attributes.addFlashAttribute("sucesso",
                "Registro salvo com sucesso!");

        return "generateMelody.html";
    }

/*
    @PostMapping
    public String save(@Valid Melodia melodia,
                               BindingResult result,
                               Model model,
                               RedirectAttributes attributes) {
        if ( result.hasErrors() ) {
            model.addAttribute("melodia", melodia);
            return "melodia/form";
        }

        melodiaService.save(melodia);
        attributes.addFlashAttribute("sucesso",
                "Melodia gerada com sucesso!");
        return "redirect:/melodia/generatedMelody.html";
    }*/

    @PostMapping
    public String player(@Valid MelodyParameter melodyParameter,
                         BindingResult result,
                         Model model,
                         RedirectAttributes attributes) {
       /* if (result.hasErrors()) {
            model.addAttribute("melodyParameter", melodyParameter);
            return "melodyParameter/form";
        }*/

        //String scale = melodyParameter.getMain_note_scale() + " " + melodyParameter.getScale_type();

        /*String teste = new String(melodyParameter.getMain_note_scale() + " " + melodyParameter.getScale_type());

        RandomMelody randomMelody = new RandomMelody(new ArrayList<String>(Arrays.asList(RandomMelody.keys.get(teste))));*/
/*
        RandomMelody randomMelody = new RandomMelody();

        //List<String> lista = new ArrayList<String>(List.of(randomMelody.keys.get(melodyParameter.getMain_note_scale() + " " + melodyParameter.getScale_type())));
       // List<String[]> list = List.<String[]>of(randomMelody.keys.get(melodyParameter.getMain_note_scale() + " " + melodyParameter.getScale_type()));
        String[] array = new String[100];

        randomMelody.setNotes(Arrays.asList(randomMelody.keys.get(teste)));*/


       // randomMelody.setNotes(array);

        //String scale = melodyParameter.getMain_note_scale() + " " + melodyParameter.getScale_type();
        RandomMelody randomMelody = new RandomMelody(new ArrayList<String>(Arrays.asList(RandomMelody.keys.get(melodyParameter.getMain_note_scale() + " " + melodyParameter.getScale_type()))));

        randomMelody.setMainInstrumentName(melodyParameter.getInstrument_name());
        randomMelody.setOctaveInterval(melodyParameter.getQty_octaves());
        randomMelody.setBpm(melodyParameter.getBpm());
        randomMelody.setLength(melodyParameter.getQty_repetitions());

        generateMelodyService.createMelody(randomMelody);

        // generateMelodyService.playOnRepeat(melodyParameter.getQty_repetitions().intValue());

        melodyParameterService.save(melodyParameter);

        GeneratedMelody generatedMelody = new GeneratedMelody(); // rever
        generatedMelody.setDate_hour(Timestamp.valueOf(LocalDateTime.now()));
        generatedMelody.setNotes_array(randomMelody.getMelody());
        generatedMelody.setMelody_parameters_id(melodyParameter);
        generatedMelodyService.save(generatedMelody);

        attributes.addFlashAttribute("sucesso",
                "Melodia gerada com sucesso!");

        melodyService.setRandomMelody(generateMelodyService.getRandomMelody());

        try {
            melodyService.exportMelody("C:\\Users\\igorg\\Desktop\\Facul\\TCC2\\Execução tcc2\\melodyGenerator\\src\\main\\resources\\temp\\", generatedMelody.getMelody_id().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/generatedMelody";
    }
}
