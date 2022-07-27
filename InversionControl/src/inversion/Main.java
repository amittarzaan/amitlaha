package inversion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Key().run(new Car());
	}
}
	 class Key{
			public void run(Engine e){
				e.start();
			}
	 }
