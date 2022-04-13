package com.example.springbootsmsapp.service;

import com.example.springbootsmsapp.entity.Student;
import com.example.springbootsmsapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentServiceimpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<Student> students =studentRepository.findAll();
        return students;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
