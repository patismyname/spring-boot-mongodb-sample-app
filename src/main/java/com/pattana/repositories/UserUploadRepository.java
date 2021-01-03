package com.pattana.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattana.model.UserUploads;


public interface UserUploadRepository extends MongoRepository<UserUploads, Long> {

}
