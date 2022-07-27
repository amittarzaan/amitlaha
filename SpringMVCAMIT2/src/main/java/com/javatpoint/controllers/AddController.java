package com.javatpoint.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	AddController(){
		System.out.println("AddController constructer");
	}


	/*
	 * @RequestMapping("/add") public ModelAndView add(HttpServletRequest
	 * req,HttpServletResponse res) { int
	 * i=Integer.parseInt(req.getParameter("t2")); int
	 * j=Integer.parseInt(req.getParameter("t1")); int k=i+j; ModelAndView mv=new
	 * ModelAndView(); mv.setViewName("display"); mv.addObject("result", k);
	 * System.out.println("Aad Controller method called"); return mv; }
	 */
	@RequestMapping("/add") 
	public ModelAndView  add(@RequestParam("t1") int i,@RequestParam("t2") int j) {
		int k=addNumber(i,j);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", k);
		System.out.println("Aad Controller method called");
		return mv;
	}
int addNumber(int o,int p) {
	return 0+p;
}
}
