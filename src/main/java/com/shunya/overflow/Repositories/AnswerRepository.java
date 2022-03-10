package com.shunya.overflow.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shunya.overflow.Models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
}