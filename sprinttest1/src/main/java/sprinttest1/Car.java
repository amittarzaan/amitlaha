package sprinttest1;

public class Car implements Engine{
	
	String colur=null;
	
	Car(){
		System.out.println("Car Obj created");
	}
	public void engine() {
		
		System.out.println("Car Start");
		}
	public void vehicaleColor() {
		System.out.println(" vehicaleColor Car color" +colur);
	}
	public String getColur() {
		return colur;
	}
	public void setColur(String colur) {
		System.out.println("car color is setting ");
		this.colur = colur;
	}
}
