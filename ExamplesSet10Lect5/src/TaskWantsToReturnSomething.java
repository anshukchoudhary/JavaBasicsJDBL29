import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskWantsToReturnSomething {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		//you can not combine two future values but with completeable future we can
		// you can not complete a future manually but completeable future you can complete
		//future get is a blocking call
		
		 ExecutorService es = Executors.newFixedThreadPool(5);
		 Future<String> future = es.submit(new myRunnableTask5());
		 System.out.println("value in obj 333:  " +  future.isDone());//false
		 String obj = future.get();// is a blocking call
		 future.isCancelled();
		 future.isDone();
		 System.out.println("value in obj111:  " + obj);
		 
		 System.out.println("value in obj444:  " +  future.isDone());
		 
		 

	}

}

class myRunnableTask5 implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		return "Hellow everyone : GoodMorning";
	}

}
