package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	/*
 @RequestMapping("home")
  	public String  home(@RequestParam("name") String Myname,HttpSession session) {
			System.out.println("hi"+Myname);
		session.setAttribute("name", Myname);
		return "home";
	}
	*/
	/*
	 @RequestMapping("home")
	  	public ModelAndView  home(@RequestParam("name") String  myName) {
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("name",myName);
		 mv.setViewName("home");
			return mv;
		}
	 */
	 @RequestMapping("home")
	  	public ModelAndView  home(Alein a) {
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("obj",a);
		 mv.setViewName("home");
			return mv;
		}
 
 /*
 @RequestMapping("home")
	public String  home(HttpServletRequest req) {
	 HttpSession httpsession=req.getSession();
	 String name=req.getParameter("name");
		System.out.println("hi"+name);
		httpsession.setAttribute("name", name);
		return "home";
	}
	*/
}
