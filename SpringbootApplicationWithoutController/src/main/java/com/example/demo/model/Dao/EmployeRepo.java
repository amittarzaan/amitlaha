package com.example.demo.model.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Emp;

@RepositoryRestResource(collectionResourceRel = "employee",path="employee")
public interface EmployeRepo extends JpaRepository<Emp, Integer>{

}
