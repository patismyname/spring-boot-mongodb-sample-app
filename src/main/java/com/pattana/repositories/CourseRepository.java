package com.pattana.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pattana.model.Course;


@Repository
public interface CourseRepository extends MongoRepository<Course, Long>{
    
	 @Query("{'seqSec' : ?0}")
    public List<Course> getCourseBySeqSecRegexQuery(int seqSec);
}
