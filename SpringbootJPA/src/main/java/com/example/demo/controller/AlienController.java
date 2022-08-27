package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienJPARepo;
import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo alienRepo;
	@Autowired
    AlienJPARepo alienJPARepo;
	@RequestMapping("/addAlien")
	public ModelAndView addAlien(Alien a) {
		ModelAndView mv=new ModelAndView();
		alienRepo.save(a);
		mv.setViewName("home");
		mv.addObject("obj", a);
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView addAlien() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");		
		return mv;
	}
	

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("id") Integer id) {
		ModelAndView mv=new ModelAndView();
		Alien a =alienRepo.findById(id).orElse(new Alien());
		mv.setViewName("home");
		mv.addObject("obj", a);
		return mv;
	}
	
	
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(Alien a) {
		ModelAndView mv=new ModelAndView();
		Alien g=alienRepo.findById(a.getId()).orElse(new Alien());
		try {
			mv.setViewName("home");
			mv.addObject("obj", a);
			if(g.getId()>0) {
				g.setAname(a.getAname());
				g.setLang(a.getLang());
				alienRepo.save(g);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("obj", new Alien());
		}
		
		return mv;
	}
	@RequestMapping("/deleteAlien1")
	public ModelAndView deleteAlien(@RequestParam("id") Integer id) {
		System.out.println("Delete method called");
		ModelAndView mv=new ModelAndView();		
		alienRepo.deleteById(id);
		System.out.println("Delete method called and deleted success");
		Alien a=new Alien();
		a.setId(id);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/getByNameAlien")
	public ModelAndView getByNameAlien(@RequestParam("name") String name) {
		ModelAndView mv=new ModelAndView();
		List <Alien> aList=alienRepo.findByAname(name);
		mv.setViewName("home");
		mv.addObject("List", aList);
		Iterator<Alien> it= aList.iterator();
		Alien a=null;
		while(it.hasNext()) {
			a=(Alien) it.next();
			System.out.println(a.getId());
			System.out.println(a.getAname());
			System.out.println(a.getLang());
		}
		
		System.out.println("get the list");
		return mv;
	}
	
	@RequestMapping("/getByIdGaterThan")
	public ModelAndView getByIdGaterThan(@RequestParam("id") Integer id) {
		ModelAndView mv=new ModelAndView();
		List <Alien> aList=alienRepo.findByIdGreaterThan(id);
		mv.setViewName("home");
		mv.addObject("getByIdGaterThanList", aList);
		Iterator<Alien> it= aList.iterator();
		Alien a=null;
		while(it.hasNext()) {
			a=(Alien) it.next();
			System.out.println(a.getId());
			System.out.println(a.getAname());
			System.out.println(a.getLang());
		}
		
		System.out.println("get the list");
		return mv;
	}
	
	@RequestMapping("/getSortedResult")
	public ModelAndView getSortedResult(@RequestParam("lang") String lang) {
		ModelAndView mv=new ModelAndView();
		System.out.println("This is a get stored request");
		List <Alien> aList=alienRepo.findByLanguageSorted(lang);
		mv.setViewName("home");
		mv.addObject("getOrderbySOrtedList", aList);
		Iterator<Alien> it= aList.iterator();
		Alien a=null;
		while(it.hasNext()) {
			a=(Alien) it.next();
			System.out.println(a.getId());
			System.out.println(a.getAname());
			System.out.println(a.getLang());
		}
		
		System.out.println("get the list"+aList );
		return mv;
	}
	
	
	@RequestMapping("/alien/{id}")
	@ResponseBody
	public  Optional<Alien> getAlienById(@PathVariable("id") int id) {
				System.out.println("This is a get stored request");
		
		return alienJPARepo.findById(id);
	}
	//@RequestMapping(path="/alien/",produces = "application/xml")
	@RequestMapping("/alien/")
	@ResponseBody
	public  List<Alien> getAllAlien() {
				System.out.println("This is a get stored request");
		
		return alienJPARepo.findAll();
	}
}
