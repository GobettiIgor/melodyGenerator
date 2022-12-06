package br.edu.utfpr.melodyGenerator.repository;

import br.edu.utfpr.melodyGenerator.model.GeneratedMelody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneratedMelodyRepository extends JpaRepository<GeneratedMelody, Long> {

    @Query(" SELECT MAX(gm) FROM generatedmelody gm")
    GeneratedMelody findMaxGeneratedMelody();

    @Query(value = "SELECT gm FROM generatedmelody gm INNER JOIN userfeedback uf ON gm.melody_id = uf.melody_id.melody_id ORDER BY uf.grade DESC")
    List<GeneratedMelody> findGeneratedMelodyByGrade();
}