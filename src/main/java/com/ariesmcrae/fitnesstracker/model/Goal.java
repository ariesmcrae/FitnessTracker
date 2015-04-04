package com.ariesmcrae.fitnesstracker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
//use @Table(NAME="goals") if u want to override the table name from GOAL to GOALS.

public class Goal {
	@Id @GeneratedValue //@Column(name="GOAL_ID")
	//Use @Column to override column name from ID to GOAL_ID
	private Long id;

	@NotNull	
	@Range(min = 1, max = 120) //For string, use eg. @Size(min = 3, max = 80)
	private int minutes;
	
	//Remove mappedBy to make it unidirectional
	//1 Goal can have zero to many Exercises.
	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@Id")
	@JsonManagedReference	
	private List<Exercise> exercise = new ArrayList<Exercise>();

	public Long getId() {
		return id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

    public List<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise(List<Exercise> exercise) {
        this.exercise = exercise;
    }
	
}
