package com.ariesmcrae.fitnesstracker.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariesmcrae.fitnesstracker.model.Activity;
import com.ariesmcrae.fitnesstracker.model.Exercise;
import com.ariesmcrae.fitnesstracker.repository.ExerciseRepo;


@Service("exerciseService")
public class ExerciseService {

    @Autowired
    private ExerciseRepo repo;
    
	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}
	
	
	@Transactional
	public void save(Exercise exercise) {
	    repo.save(exercise);
	}
	
}
