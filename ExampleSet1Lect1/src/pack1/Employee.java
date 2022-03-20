package pack1;

public class Employee {

	private int id;
	private String empName;
	private int age;

	// Method overloading - compile time poly
	// return type doesnot matters for method overloading
	// access specifier also doesnot matter for the case of method overlaoding

	/*public double getBMI() {
		return 40.0;
	}

	public double getBMI(double weight) {
		return 40.0;
	}

	public double getBMI(double weight, double height) {
		return 40.0;
	}

	public double getBMI(String val) {
		return 51.0;
	}

	public double getBMI(double weight, String gender) {
		return 40.0;
	}

	public double getBMI(String gender, double weight) {
		return 400.0;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int displayDetails() {
		System.out.println("Inside : PolymorphismExample class");
		return 50;
	}

	public int displayDetails3() {
		System.out.println("Inside : Employye class2");
		return 30;
	}
	
	
	

}
