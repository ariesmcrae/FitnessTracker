package com.ariesmcrae.fitnesstracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ariesmcrae.fitnesstracker.model.Goal;
import com.ariesmcrae.fitnesstracker.model.projection.GoalReport;
import com.ariesmcrae.fitnesstracker.service.GoalService;

@RestController //POST=create, GET=read, PUT=update, DELETE=delete.
public class GoalController {

    private final static Logger LOG = LoggerFactory.getLogger(GoalController.class);    
    
	@Autowired
	private GoalService service;
	

	// blahblah.com/goal POST	
	// Use Chrome Postman raw { "minutes":30 }
	@RequestMapping(value="/goal", method=RequestMethod.POST)	
	public @ResponseBody Goal create(@RequestBody Goal goal) {
		service.save(goal);
		return goal;
	}
	
	
	// blahblah.com/goal/{id} PUT	
	@RequestMapping(value = "goal/{id}", method = RequestMethod.PUT)
	public @ResponseBody Long update(@PathVariable Long id, @RequestBody Goal goal) {
	    service.save(goal);
		return id;
	}
	
	
    @RequestMapping(value = "/goal", method = RequestMethod.GET)
    public @ResponseBody List<Goal> findAllGoals() {
        return service.findAllGoals(); 
    }
	
    
    @RequestMapping(value = "/goal/report", method = RequestMethod.GET)
	public @ResponseBody List<GoalReport> getReport() {
        return service.getGoalReport();
    }
}
