package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;
import com.example.demo.dao.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo studentRepo;

	@GetMapping(path="/student")
	public List<Student> getStudent() {
		List<Student> students=studentRepo.findAll();
		return students;
		
	}
}
