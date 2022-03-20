package pack2;


// 
class Student {
	 String stuName = "RamShayam";
}

class School extends Student {
	String stuName = "DAV School";

	public void displayDetails() {
		System.out.println(stuName);
		System.out.println(super.stuName);
	}

}

public class ExampleSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School school = new School();
		school.displayDetails();
		

	}

}
