package br.edu.utfpr.melodyGenerator.service.impl;

import br.edu.utfpr.melodyGenerator.model.UserFeedback;
import br.edu.utfpr.melodyGenerator.repository.UserFeedbackRepository;
import br.edu.utfpr.melodyGenerator.service.UserFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFeedbackServiceImpl extends CrudServiceImpl<UserFeedback, Long> implements UserFeedbackService {

    @Autowired
    private UserFeedbackRepository userFeedbackRepository;

    protected JpaRepository<UserFeedback, Long> getRepository() {
        return userFeedbackRepository;
    }

}