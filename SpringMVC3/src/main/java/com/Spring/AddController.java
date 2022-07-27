package com.Spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	public AddController() {
		System.out.println("new  addcontroller");
	}
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i,@RequestParam("t2") int j)	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", i+j);
		return mv;
	}
}
