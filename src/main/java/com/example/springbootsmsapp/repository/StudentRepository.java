package com.example.springbootsmsapp.repository;

import com.example.springbootsmsapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
