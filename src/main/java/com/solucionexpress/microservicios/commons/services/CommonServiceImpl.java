package com.solucionexpress.microservicios.commons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonServiceImpl<E, R extends CrudRepository<E,Long>> implements CommonService<E> {

    @Autowired
    protected R respository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return respository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return respository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return respository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        respository.deleteById(id);
    }
}
