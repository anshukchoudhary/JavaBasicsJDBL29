package Doubts;

public class SuperDoubts extends SuperDoubtsParent {
	int id;
	int age;
	String name;
	int changedVal;
	
	public  void test(){
		changedVal = this.val;
		System.out.println("changedVal value fo the val " + changedVal);
	}
	
	
	public SuperDoubts(int id, int age, String name) {
		super(2);
		this.id = id;
		this.age = age;
		this.name = name;
	}


	public static void main(String[] args) {
		SuperDoubts sp = new SuperDoubts(12,14,"Game");	
		sp.test();

	}
}
