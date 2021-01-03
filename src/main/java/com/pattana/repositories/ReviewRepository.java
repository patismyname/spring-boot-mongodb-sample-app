package com.pattana.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pattana.model.Review;


@Repository
public interface ReviewRepository extends MongoRepository<Review, Long>{
	
	 @Query("{'titleId' : ?0}")
	    public List<Review> getReviewByTitleRegexQuery(int titleId);

}
