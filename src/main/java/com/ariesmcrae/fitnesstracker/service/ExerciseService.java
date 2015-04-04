package com.ariesmcrae.fitnesstracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariesmcrae.fitnesstracker.model.Exercise;
import com.ariesmcrae.fitnesstracker.repository.ExerciseRepo;


@Service("exerciseService")
public class ExerciseService {

    @Autowired
    private ExerciseRepo repo;
    
	
	@Transactional
	public void save(Exercise exercise) {
	    repo.save(exercise);
	}
	
}
