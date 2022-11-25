package br.edu.utfpr.melodyGenerator.service.impl;

import br.edu.utfpr.melodyGenerator.model.MelodyParameter;
import br.edu.utfpr.melodyGenerator.repository.MelodyParameterRepository;
import br.edu.utfpr.melodyGenerator.service.MelodyParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MelodyParameterServiceImpl extends CrudServiceImpl<MelodyParameter, Long> implements MelodyParameterService {

    @Autowired
    private MelodyParameterRepository melodyParameterRepository;

    protected JpaRepository<MelodyParameter, Long> getRepository() {
        return melodyParameterRepository;
    }

/*
    @Override
    public List<Melodia> findAll() {
        return null;
    }

    @Override
    public List<Melodia> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Melodia> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Melodia save(Melodia entity) {
        return null;
    }

    @Override
    public Melodia saveAndFlush(Melodia entity) {
        return null;
    }

    @Override
    public Iterable<Melodia> save(Iterable<Melodia> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public Melodia findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Melodia entity) {

    }

    @Override
    public void delete(Iterable<Melodia> iterable) {

    }

    @Override
    public void deleteAll() {

    }*/
}


