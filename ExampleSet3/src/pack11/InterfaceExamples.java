package pack11;

public interface InterfaceExamples {

	// java 7 we only able to declare 
	public Double getWeight();
	public Double getHeight();
	
	// from java8 onwards we have been given default keyword which is a way to have method body interfaces
	public default Double getConstantDetails(){
		
		System.out.println("Inside the contants detials");
		
		return 77.0;
		
	}
	// static - stack
	// non-static - heap
	
	
	
	
}
