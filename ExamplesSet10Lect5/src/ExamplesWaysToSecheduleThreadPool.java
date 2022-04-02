import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExamplesWaysToSecheduleThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
		 	es.schedule(new myRunnableTask4(), 10, TimeUnit.SECONDS);//will execute only once 
		 	es.scheduleAtFixedRate(new myRunnableTask4(), 5, 5, TimeUnit.SECONDS);
		
			System.out.println("Thread details 7878 : " + Thread.currentThread());
		 

	}

	}



class myRunnableTask4 implements Runnable {

	@Override
	public void run() {
		// System.out.println("Value after addition of 10+5 is " + (10+5));
		System.out.println("Thread details " + Thread.currentThread());

	}

}

