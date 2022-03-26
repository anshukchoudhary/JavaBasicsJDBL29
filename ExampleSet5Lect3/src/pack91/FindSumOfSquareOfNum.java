package pack91;
import java.util.Arrays;
import java.util.List;

public class FindSumOfSquareOfNum {

	public static void main(String[] args) {
		// streams and lambdas
		// // We want to find a sum of square of all the even number in the
		// given List

		// Iterative way
		List<Integer> inputNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		int sum = 0;
		for (int i = 0; i < inputNums.size(); i++) {
			if (inputNums.get(i) % 2 == 0) {
				sum += inputNums.get(i) * inputNums.get(i);

			}
		}

		System.out.println("Sum of the square of even num- " + sum);
		// you can have only one terminal operation pee streams
		
		int answer = inputNums.stream().filter((nums) -> nums%2 == 0)
						  .map((x) -> x*x)
						  .reduce(0, (val1,val2) -> val1+val2);
		
		System.out.println("Sum of the square of even num 333- " + answer);
		
		
		
		

	}

}
