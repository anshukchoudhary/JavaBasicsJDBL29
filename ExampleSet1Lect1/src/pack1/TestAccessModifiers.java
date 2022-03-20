package pack1;

public class TestAccessModifiers {
//Constructor - it is not the compiler responsibilty to create default constructor id there is arleady a  parameterized constructor.
// Consturctor is used to initialse some space in the memory location for the object

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.id = 1; // public
		person.age = 23; // protected
		person.gender = "XYZ";//Default
		person.setSalary(5000);;
		//person.address // address is private so not accessble
		
		
		
	}

}
