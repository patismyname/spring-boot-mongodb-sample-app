package com.pattana.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pattana.model.Product;


public interface ProductRepository extends CrudRepository<Product, String> {
	
	@Override
    void delete(Product deleted);
}
