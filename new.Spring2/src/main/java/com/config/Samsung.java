package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired
	@Qualifier("snapDragen")
	 MobileProcessor mp;
	 


	public MobileProcessor getMp() {
		return mp;
	}

	public void setMp(MobileProcessor mp) {
		this.mp = mp;
		
	}
	
	public void config() {
		System.out.println("Samsun 8GB RAM ");
		mp.process();
	}
}
