package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
