package pack1;

import java.util.ArrayList;
import java.util.List;

// super on the first line 
//  PolymorphismExample emp = new Employee();	 with example

public class PolymorphismExample extends Employee{
	// run time - jvm decides method overriding. is a way to achive run time
	// polymorphism
	// compile time - jdk method overloading. is a way to achive compile time
	// polymorphism

	public int displayDetails() {
		System.out.println("Inside : PolymorphismExample class");
		return 50;
	}

	public int displayDetails3() {
		System.out.println("Inside : Employye class2");
		return 30;
	}
	
	//	Employee emp = new PolymorphismExample();
	// if declared in parent and overrided in child load the method.
	// if not declared in parent but only present in child do not no load the method.
	
	
	
	public static void main(String[] args) {
	//	Employee emp = new Employee();
	
	//  PolymorphismExample emp = new Employee();	// not possible
	//	PolymorphismExample emp = new PolymorphismExample();	  
		Employee emp = new PolymorphismExample();
		
		
		ArrayList<String> obj = new ArrayList<String>();
		obj.trimToSize();
		List<String> obj2 = new ArrayList<String>();
		//obj2.tri
		
		
		
		
		
		
	}

}
