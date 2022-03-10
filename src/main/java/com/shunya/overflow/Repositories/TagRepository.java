package com.shunya.overflow.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shunya.overflow.Models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	boolean existsBySubject(String subject);
	Tag findBySubject(String subject);
}