package com.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Mediatak implements MobileProcessor{
	public void process() {
		System.out.println("Mediatak processor");
	};
}
