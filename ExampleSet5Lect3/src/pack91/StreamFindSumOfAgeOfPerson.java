package pack91;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindSumOfAgeOfPerson {

	public static void main(String[] args) {
		List<PersonIndia> persons = Arrays.asList( 
				new PersonIndia(14,"John","Den"),
				new PersonIndia(16,"Ram","Den"),
				new PersonIndia(13,"Abhinav","Den"),
				
				new PersonIndia(18,"Shyam","Den"),
				new PersonIndia(11,"Ali","Den"),
				new PersonIndia(52,"Pope","Den"));
		
		
		
		//PARAMETER ON WHICH THE RESULT OF FIND FIRST DEPENDS
		// collection type - List and Streams type - sequntial stream
		//but suppose for the case when we have parallel stream the result will be unpredictable
		
		// We can have only one terminal operation - collect,reduce
		//Intermediate funciton - filter, map
		//
		
		
		//find the sum of all the ages
		
		//int answer = persons.stream().map(p -> p.getAge()).reduce(0,(val1,val2) -> val1+val2);
		
		int answer = persons.stream().map(p -> p.getAge()).reduce(0,Math::addExact);
		
		System.out.println("Result: " + answer);
		
		
		
		//Second case
		// find the count of persons whose fname count is 3
		long ans = persons.stream().filter(p -> p.getFname().length()==3).count();
		
		
		// print the values for which fname count is 3
		persons.stream().filter(p -> p.getFname().length()==3).forEach(x ->{System.out.println(x.fname);});
		
		//Find the first person in colelction whose age is more 20
	
		//PersonIndia p = persons.stream().filter(x -> x.getAge()>10).findFirst().orElse(new PersonIndia(56,"Tia","Denmark"));
		//System.out.println("value to be printed find first case: " + p.getFname());
		
		
		//PersonIndia p = persons.stream().filter(x -> x.getAge()>54).findFirst().orElseThrow(() -> new CustomException("No value is found 123"));
		//System.out.println("value to be printed find first case: " + p.getFname());
		
		Integer sumValue = null;
		Optional<Integer> obj = Optional.ofNullable(sumValue);
		
		System.out.println("Value: " + obj.isPresent());
		
		
	//	PersonIndia person5 = persons.parallelStream().filter(x -> x.getAge()>=12).findAny().orElse(null);
		
		PersonIndia person5 = persons.stream().filter(x -> x.getAge()>=12).findAny().orElse(null);
		
		System.out.println("value person5 : " + person5.getFname());
		
		//ShortCircuiting terminal operations
		//find first - will excute only till first value found
		// foreach - is not ShortCircuiting will execute for each elemnt
		
		
		
		//Stream and iterative approach both will take same amount of time.
		
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//input array 	List<Integer> ages = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//2,4,10,16,26...................
		//Question : print the square of all the even ages from the person list and square + 1 for odd ages ?
		
		
		
		
				

	}

}
