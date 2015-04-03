package com.ariesmcrae.fitnesstracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ariesmcrae.fitnesstracker.model.Exercise;


@Repository("exerciseRepository")
@Transactional
public class ExerciseRepo {

    @PersistenceContext
    private EntityManager em;
    
    public void save(Exercise exercise) {
        if (exercise.getId() == null) {
            em.persist(exercise); //create
            em.flush();            
        } else {
            em.merge(exercise); //update
        }
    }
}
