package com.pattana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattana.model.Role;



public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
