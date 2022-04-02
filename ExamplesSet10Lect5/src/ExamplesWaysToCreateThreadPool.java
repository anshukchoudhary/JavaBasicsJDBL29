import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExamplesWaysToCreateThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 1; i < 20; i++) {
			es.execute(new myRunnableTask2());
		}
		System.out.println("Thread details 7878 : " + Thread.currentThread());

	}

}

class myRunnableTask2 implements Runnable {

	@Override
	public void run() {
		// System.out.println("Value after addition of 10+5 is " + (10+5));
		System.out.println("Thread details " + Thread.currentThread());

	}

}