import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExamplesWaysToCreateCachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ExecutorService es = Executors.newCachedThreadPool();// you need not to pass anything to constructor or size
		 // if not threads are free cached thread pool will create new thread for task 
		 //also it will kill or teminated the thread if thread was found idle for 60s
		 
			for (int i = 1; i < 20; i++) {
				es.execute(new myRunnableTask3());
			}
			System.out.println("Thread details 7878 : " + Thread.currentThread());
		 

	}

}

class myRunnableTask3 implements Runnable {

	@Override
	public void run() {
		// System.out.println("Value after addition of 10+5 is " + (10+5));
		System.out.println("Thread details " + Thread.currentThread());

	}

}
