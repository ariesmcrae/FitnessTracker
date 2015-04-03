package com.ariesmcrae.fitnesstracker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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



    @SuppressWarnings("unchecked")
    public List<Goal> findAllGoals() {
        String jpql = "Select g from Goal g";
        Query query = em.createQuery(jpql);

        return query.getResultList();
    }
    
    
    
    @SuppressWarnings("unchecked")
    public List<GoalReport> findAllGoalReport() {
        //projection allows u to get data from different tables. i.e. custom query.
        String projection = "Select new com.ariesmcrae.fitnesstracker.model.projection.GoalReport(g.minutes, e.minutes, e.activity) " +
                            "from Goal g, Exercise e where g.id = e.goal.id";
        
        Query query = em.createQuery(projection);
        
        return query.getResultList();
    }

}
