package com.pattana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pattana.model.Posts;


@Repository
public interface PostsRepository extends MongoRepository<Posts, Long>{

}
