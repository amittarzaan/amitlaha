package spring.ioc;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	public void check() {
		System.out.println("dhor raha hai..");
	}
}
