package com.example.springbootsmsapp.service;

import com.example.springbootsmsapp.entity.Student;

import java.util.List;

public interface StudentService  {
    public List<Student> findAll();

    public Student findById(Long id);

    public void save(Student theStudent); // save or update

    public void deleteById(Long id);
}
