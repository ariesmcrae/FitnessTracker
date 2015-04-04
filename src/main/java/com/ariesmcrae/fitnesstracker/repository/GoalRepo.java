package com.ariesmcrae.fitnesstracker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ariesmcrae.fitnesstracker.model.Goal;
import com.ariesmcrae.fitnesstracker.model.projection.GoalReport;

@Repository("goalRepository")
public class GoalRepo {

	  // An EntityManager will be automatically injected from entityManagerFactory setup on DatabaseConfig class.
	  @PersistenceContext
	  private EntityManager em;	
	
	  
	  public void save(Goal goal) {
	      if (goal.getId() == null) {
	          em.persist(goal); //create
	          em.flush(); 
	      } else {
	          em.merge(goal); //update
	      }
	  }

	  
	  
	  public Goal getById(long id) {
	      return em.find(Goal.class, id);
	  }



    public List<Goal> findAllGoals() {
        TypedQuery<Goal> query = em.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class);

        return query.getResultList();
    }
    
    
    
    public List<GoalReport> findAllGoalReport() {
    	TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
        
        return query.getResultList();
    }

}
