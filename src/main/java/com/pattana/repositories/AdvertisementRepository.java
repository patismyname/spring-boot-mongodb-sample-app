package com.pattana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pattana.model.Advertisement;


@Repository
public interface AdvertisementRepository extends MongoRepository<Advertisement, Long>{

}
