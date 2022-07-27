package sprinttest1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      Engine obj =  (Engine) context.getBean("engine");	   
	      //obj.engine();
	      obj.vehicaleColor();
	      Airoplan arpl=(Airoplan) context.getBean("airoplan");
	      arpl.showAiroplan();
	      
	}

}
