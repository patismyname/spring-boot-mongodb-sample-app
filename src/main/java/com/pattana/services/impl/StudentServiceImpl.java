package com.pattana.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pattana.model.Student;
import com.pattana.repositories.StudentRepository;
import com.pattana.services.StudentService;

import java.util.List;

/**
 * @author ragcrix
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

   
    public Student findByStudentNumber(long studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

   
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

   
    public List<Student> findAllByOrderByGpaDesc() {
        return studentRepository.findAllByOrderByGpaDesc();
    }

    
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

  
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
}
