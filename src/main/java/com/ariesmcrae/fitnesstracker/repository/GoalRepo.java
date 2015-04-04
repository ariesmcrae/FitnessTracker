package com.ariesmcrae.fitnesstracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ariesmcrae.fitnesstracker.model.Goal;
import com.ariesmcrae.fitnesstracker.model.projection.GoalReport;

@Repository("goalRepository")
public interface GoalRepo extends JpaRepository<Goal, Long>{

	//Spring Data JPA has no support for NamedQuery (unlike regular JPA), therefore we put the query here.
	//In NamedQuery, we put the query into the Entity itself.
	@Query("Select new com.ariesmcrae.fitnesstracker.model.projection.GoalReport(g.minutes, e.minutes, e.activity) from Goal g, Exercise e where g.id = e.goal.id")	
	List<GoalReport> findAllGoalReport();

}
