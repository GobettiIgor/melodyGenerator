package br.edu.utfpr.melodyGenerator.repository;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeneratedMelodyRepository extends JpaRepository<GeneratedMelody, Long> {

    @Query(" SELECT MAX(gm) FROM generatedmelody gm")
    GeneratedMelody findMaxGeneratedMelody();
}
