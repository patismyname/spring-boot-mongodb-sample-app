package com.pattana.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattana.model.User;


public interface UserRepository extends MongoRepository<User, String> {

	//Optional<User> findById(String id);
	//User findByEmail(String email);
}
