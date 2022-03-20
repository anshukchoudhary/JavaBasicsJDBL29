package pack11;

public class FinalKeyWord {
	
	//public static final int count = 200;
	//1)in a static block
	// 2) while declaring
	
	//	public final int count = 200;
	//1) block
	// 2) contructor
	//3) while declaring
	
	
	//Final Functions - we can not override the method in child class
	
	//Final Class - Can not be inherited also when we declare a class as final automatically all the
	// functions in the class will becom final
	
	

	public final int count = 200;
	// initilise while declaring
	// public final int count = 450;

	// initilizer block
	/*
	 * { this.count = 100; }
	 */

	/*
	 * FinalKeyWord(){ this.count = 300; }
	 */

	// places where we can initilase final attribute - contructor,declaring a
	// var, initiliazer block we can initilase

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalKeyWord obj = new FinalKeyWord();
		// obj.count = 200; not possible ;

	}

}
