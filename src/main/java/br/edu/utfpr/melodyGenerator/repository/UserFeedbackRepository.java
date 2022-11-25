package br.edu.utfpr.melodyGenerator.repository;

import br.edu.utfpr.melodyGenerator.model.UserFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {

}
