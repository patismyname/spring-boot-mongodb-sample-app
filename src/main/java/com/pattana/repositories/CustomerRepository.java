package com.pattana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pattana.model.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long>{

}
