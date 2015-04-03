package com.ariesmcrae.fitnesstracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Exercise {

    @Id @GeneratedValue
    private Long id;    
    
    @NotNull
	private String activity;

    @Range(min = 1, max = 120)
	private int minutes;

    @ManyToOne //Many exercises belong to only 1 Goal
    //@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@Id")
    @JsonBackReference    
    private Goal goal;
    
    
    
    
    public String getActivity() {
		return activity;
	}
	
	public Long getId() {
        return id;
    }

	public int getMinutes() {
		return minutes;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setId(Long id) {
        this.id = id;
    }

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
	
}
