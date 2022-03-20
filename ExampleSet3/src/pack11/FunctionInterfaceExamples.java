package pack11;

import java.util.UUID;

public class FunctionInterfaceExamples {

	// Funtional interface is an interface having one and only one abstarct
	// method
	// we mainly have this to use lambda expression in Funtional interface

	public static void main(String[] args) {
		FIinterface obj = new FIinterface() {

			@Override
			public String calculate() {
				// TODO Auto-generated method stub
				System.out.println("Inside calculate() :");
				return UUID.randomUUID().toString();
			}

		};

		FIinterface obj2 = () -> {
			System.out.println("n number of lines");
			return UUID.randomUUID().toString();
		};

		String val = obj.calculate();
		System.out.println("value received " + val);
		String val2 = obj2.calculate();

		System.out.println("value received from obj2 " + val2);
		
	

	}

}
/*
 * @Override public String calculate() { // TODO Auto-generated method stub
 * return null; }
 */