package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienJPARepo;
import com.example.demo.model.Alien;

@RestController
public class AlienJPAController {
	@Autowired
	AlienJPARepo alienJPARepo;
	
	@RequestMapping("/alien1/{id}")
	public  Optional<Alien> getAlienById(@PathVariable("id") int id) {
				System.out.println("This is a get stored request");
		
		return alienJPARepo.findById(id);
	}
	//@RequestMapping(path="/alien/",produces = "application/xml")
	@GetMapping(path="/alien1/")
	public  List<Alien> getAllAlien() {
				System.out.println("This is a get stored request");
		
		return alienJPARepo.findAll();
	}
	@PostMapping("/alien1/addAlien")
	public Alien addAlien(@RequestBody Alien a) {
		
		alienJPARepo.save(a);
			return a;
	}
	
	@DeleteMapping("/alien1/deleteAlien/{id}")
	public String  deleteAlien(@PathVariable("id") int id) {
		try {
			
		
		Alien a=alienJPARepo.getById(id);
		System.out.println("Objected Before delete :: "+a);
		alienJPARepo.delete(a);			
		System.out.println("Objected After deleted :: "+a);
		} catch (Exception e) {
			System.out.println("Exception occured"+e.getMessage());
			e.getStackTrace();
		}
			return "deleted";
	}
	@PutMapping("/alien1/addAlien")
	public Alien updateAlien(@RequestBody Alien a) {
		System.out.println("updateAlien methi called ...................1");
		Alien b=null;
		try {
			System.out.println("updateAlien methi called ...................2");
			 b=alienJPARepo.getById(a.getId());
			 if(b.getId()>0) {
				 alienJPARepo.save(a);
			 }else {
				 System.out.println("Object not found ");
			 }
			 System.out.println("updateAlien methi called ...................3");
			
				System.out.println("updateAlien methi called ...................4");
		} catch (Exception e) {
			System.out.println("updateAlien methi called ...................5");
			System.out.println("Exception occured :: "+e.getMessage());
		}
		System.out.println("updateAlien methi called ...................6");
			return a;
	}

}
