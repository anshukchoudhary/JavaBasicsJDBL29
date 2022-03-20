package Doubts;

public class SuperDoubtsParent {

	public int val = 200;
	
	public SuperDoubtsParent(int i) {
		// TODO Auto-generated constructor stub
		val= val/i;
		System.out.println("Hellow there age");
	}

	public SuperDoubtsParent() {
		//val= val;
		val = 500;
		System.out.println("Hellow there SuperDoubtsParent");
	}

}
