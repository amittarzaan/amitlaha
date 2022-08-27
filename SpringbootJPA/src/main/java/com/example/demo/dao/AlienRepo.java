package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

	List<Alien> findByAname(String aname);
	List<Alien> findByIdGreaterThan(int id);	
	@Query("from Alien where lang=?1 order by aname desc")
	List<Alien> findByLanguageSorted(String lang);
}
