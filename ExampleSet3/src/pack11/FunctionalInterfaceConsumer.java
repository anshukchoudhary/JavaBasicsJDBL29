package pack11;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Consumer Functional Interface
		// Consumer will conumes something and do it processing
		// Does not returns anythings

		Consumer<String> consumerObj = (paramater) -> {
			String name = "";
			for (int i = 0; i < 3; i++) {
				// name = name+e;
				name += paramater;
			}

			System.out.println(name);
		};

		Consumer<String> consumerObj2 = (e) -> System.out.println(e);

		consumerObj.accept("Ali");
		consumerObj2.accept("Shyam");

		// Supplier Functional interface
		// it doesnot accepts any params
		// it will return somethings

		Supplier<String> supplier = () -> {
			return UUID.randomUUID().toString();
		};

	
		Supplier<String> supplier2 = UUID.randomUUID()::toString;
		System.out.println("Supplier value " + supplier.get());
		
		// Function Functional interface
		// is combination of both supplier and consumer interface
		// this accepts as well as returns the output
		
		Function<String,Integer> func = (parm) -> Integer.parseInt(parm);
		
		int num = func.apply("80");
		System.out.println("Supplier value  #1672772 --- " + num);
		
		
		
		// We want to find a sum of square of all the number in the given list
		// streams and lambdas

	}

}
