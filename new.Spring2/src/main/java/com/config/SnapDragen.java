package com.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class SnapDragen implements MobileProcessor{

	public void process() {
		System.out.println("snap dragen processor");
	};
}
