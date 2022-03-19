package pack1;

public class Person {
	// Access Modifiers
	// private - visible inside only current class
	// no modifier - visible inside the current package
	// protected - visible inside the current package + child classes
	// public - visible everywhere in the project
	
	

	public int id;
	protected int age;
	public String name;
	private String address;
	String gender;
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
		// more logics 
		// more logics
		// tax calu

	}

}
