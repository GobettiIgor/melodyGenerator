package br.edu.utfpr.melodyGenerator.repository;

import br.edu.utfpr.melodyGenerator.model.MelodyParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MelodyParameterRepository extends JpaRepository<MelodyParameter, Long> {
}