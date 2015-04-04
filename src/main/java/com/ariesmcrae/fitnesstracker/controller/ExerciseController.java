package com.ariesmcrae.fitnesstracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ariesmcrae.fitnesstracker.model.Exercise;
import com.ariesmcrae.fitnesstracker.model.Goal;
import com.ariesmcrae.fitnesstracker.service.ExerciseService;
import com.ariesmcrae.fitnesstracker.service.GoalService;


@RestController
public class ExerciseController {

    private final static Logger LOG = LoggerFactory.getLogger(ExerciseController.class);
    
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired 
	private GoalService goalService;
	
	
	
	//localhost:8080/goal/1/exercise
	//{"activity":"running", "minutes":50}
	@RequestMapping(value = "/goal/{goalId}/exercise",  method = RequestMethod.POST)
	public @ResponseBody Exercise addMinutesToGoal(@PathVariable Long goalId,  @RequestBody Exercise exercise) {
		LOG.info("Adding minutes to goal");
		
	    Goal goal = goalService.getGoal(goalId);
	    
	    exercise.setGoal(goal);
	    
	    exerciseService.save(exercise);
	    
	    return exercise;
	}

	
}
