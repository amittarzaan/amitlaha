package com.amit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {

	@RequestMapping(value="/add")
	void add() {
		System.out.println("I am add method");
	}
}
