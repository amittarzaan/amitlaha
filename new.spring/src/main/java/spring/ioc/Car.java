package spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	@Autowired
	private Tyre tr;
	public Tyre getTr() {
		return tr;
	}
	public void setTr(Tyre tr) {
		this.tr = tr;
	}
	public void check() {
		System.out.println("chal raha hai.." +"Tyre "+tr);
	}
}
