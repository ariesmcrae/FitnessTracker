package com.ariesmcrae.fitnesstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ariesmcrae.fitnesstracker.model.Goal;
import com.ariesmcrae.fitnesstracker.model.projection.GoalReport;
import com.ariesmcrae.fitnesstracker.repository.GoalRepo;

@Service("goalService")
public class GoalService {

	@Autowired
	private GoalRepo repo;

	
	@Transactional
	public void save(Goal goal) {
		repo.save(goal);
	}
	
	
    public Goal getGoal(Long id) {
        return repo.getById(id);
    }


    public List<Goal> findAllGoals() {
        return repo.findAllGoals();
    }
	
    
    public List<GoalReport> getGoalReport() {
        return repo.findAllGoalReport();
    }

}
