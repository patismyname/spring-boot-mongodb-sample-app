package com.pattana.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pattana.model.Image;




public interface ImageRepository extends MongoRepository<Image, String> {

    
	 @Query("{'seqSec' : ?0}")
    public List<Image> getBySeqSecRegexQuery(int seqSec);
}
