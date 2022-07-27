package sprinttest1;

public class Bike implements Engine {
	String colur=null;
	Bike(){
		System.out.println("Bike Obj created");
	}
	public void engine() {
		
	System.out.println("Bike Start");
	}
	public void vehicaleColor() {
		System.out.println(" vehicaleColor Bike color" +colur);
	}
	public String getColur() {
		return colur;
	}
	public void setColur(String colur) {
		System.out.println("Bike color is setting ");
		this.colur = colur;
	}
}
