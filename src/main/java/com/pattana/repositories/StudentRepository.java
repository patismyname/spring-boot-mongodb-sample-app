package com.pattana.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattana.model.Student;

import java.util.List;

/**
 * @author ragcrix
 */

// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

}
