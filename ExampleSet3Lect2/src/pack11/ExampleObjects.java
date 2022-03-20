package pack11;

import java.util.HashMap;
import java.util.HashSet;

public class ExampleObjects {
	public static void main(String[] args) {

		Person person1 = new Person();
		person1.age = 25;
		person1.id = 10;
		person1.name = "John";

		Person person2 = new Person();
		person2.age = 25;
		person2.id = 10;
		person2.name = "John";

		// ==
		// equals
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());

		System.out.println("Equals value after comparsion" + (person1.equals(person2))); // false

		HashMap<Person, Integer> map2 = new HashMap<>();
		map2.put(person1, 21);
		map2.put(person2, 22);
		System.out.println("Size of the value of map2 - " + map2.size());

		HashMap<String, Integer> map = new HashMap<>();
		// System.out.println();

		map.put("Abhinav", 500);
		
		HashSet<Person> personSet = new HashSet<>();
		
		personSet.add(person1);
		personSet.add(person2);
		
		System.out.println("personSet COUNT VALUE - " + personSet.size());
		
		
		
		

	}
}
