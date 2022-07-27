package spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext apconx=new ClassPathXmlApplicationContext("spring.xml");
		
		  Object obj=(Vehicle)apconx.getBean("car"); 
		  ((Vehicle) obj).check();
		
		/*
		 * Object tr=apconx.getBean("tyre"); 
		 * System.out.println(tr);
		 */
	}

}
