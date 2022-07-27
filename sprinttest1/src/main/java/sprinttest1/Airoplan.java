package sprinttest1;

public class Airoplan {

	 String colour1;
	 Integer colour2;
		
		  public Airoplan(String col,Integer col2) { 
			  System.out.println("by Airoplan Constructer ");
		  this.colour1=col; 
		  colour2=col2;
		  }
		 
	 
	

	public void showAiroplan() {
		 System.out.println("Airoplan colour is "+colour1);
		 System.out.println("Airoplan colour is "+colour2);
	 }

	
}
