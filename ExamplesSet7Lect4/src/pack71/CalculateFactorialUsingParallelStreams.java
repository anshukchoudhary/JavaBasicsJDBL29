package pack71;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class CalculateFactorialUsingParallelStreams {
	


	private static BigInteger calculate(int num)

	{
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= num; i++) {
			result = result.multiply(BigInteger.valueOf(i));

		}

		return result;

	}

	private static Integer calculateLowValue(int num)

	{
		int result = 1;
		for (int i = 2; i <= num; i++) {
			result = result * i;

		}

		return result;

	}
	//multi threading 
	//its a process of excuting multiple threads simultaneously
	//thread - thread a sub process
	//multithreadind is widely used in animations or cod or computer games
	
	//Multitasking 
	// can be achieved by - thread  based multitasking and process based mutlitasking.
	
	//advantages of mutithreading - time of execution, in less time we can given more output
	//it doesnot blocks the user as threads are independent
	//even if exception occurs , it will not disturb other threads execution
	
	//important thread - start, run, sleep, currentThread, join, isDaemon etc
	
	
	
	

	public static void main(String[] args) {
		//ForkJoinPool obj  = new ForkJoinPool(4);
		List<Integer> inputList = Arrays.asList(100, 200, 300, 400, 500,350,450);
		
		
		List<Integer> inputList2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
		//it will excute sequentially
		//[main,5,main]
		//option 1 is it will print alternately line 45 then 46 for each input
		// option 2 is it will print line num 47 for all the input then 46 for all the input
		// option 3 is it will print line num46 for all the input then 47 for all the input
		/*
		inputList2.stream().map(CalculateFactorialUsingParallelStreams::calculateLowValue).forEach(x -> 
		{ System.out.println(x);
		 System.out.println(Thread.currentThread());
		
		});*/
		
		
		//t1                  
		//card 1      and card 2  crore of debit cards cores of trnasaction
		//flow1 such as deduct balance 
		//flow2 such update balance
		//flow3 such add balance 
		
		
		
		
		inputList.stream().map(CalculateFactorialUsingParallelStreams::calculateLowValue).forEach(x -> 
		{ System.out.println(x);
			System.out.println(Thread.currentThread());
		
		});
		
		
		
	//	inputList2.stream().map(CalculateFactorialUsingParallelStreams::calculateLowValue).forEach(System.out::println);
		
		
		
		
		
		

	}

}
