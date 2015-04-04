package com.ariesmcrae.fitnesstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariesmcrae.fitnesstracker.model.Exercise;


@Repository("exerciseRepository")
public interface ExerciseRepo extends JpaRepository<Exercise, Long>{


}
