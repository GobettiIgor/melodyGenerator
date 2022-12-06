package br.edu.utfpr.melodyGenerator.service.impl;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import br.edu.utfpr.melodyGenerator.repository.GeneratedMelodyRepository;
import br.edu.utfpr.melodyGenerator.service.GeneratedMelodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratedMelodyServiceImpl extends CrudServiceImpl<GeneratedMelody, Long> implements GeneratedMelodyService {

    @Autowired
    private GeneratedMelodyRepository generatedMelodyRepository;

    protected JpaRepository<GeneratedMelody, Long> getRepository() {
        return generatedMelodyRepository;
    }

    public GeneratedMelody findMaxGeneratedMelody(){
        GeneratedMelody generatedMelody = generatedMelodyRepository.findMaxGeneratedMelody();
        return generatedMelody;
    }

    public List<GeneratedMelody> findGeneratedMelodyByGrade(){
        List <GeneratedMelody> generatedMelodyList = generatedMelodyRepository.findGeneratedMelodyByGrade();
        return generatedMelodyList;
    }
}