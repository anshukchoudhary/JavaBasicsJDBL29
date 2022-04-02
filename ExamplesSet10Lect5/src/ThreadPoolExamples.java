
public class ThreadPoolExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// task1 task2 task3 ...taskn
		// t1 t2 tn
		for(int i=1;i<100;i++){
		Thread th = new Thread(new myRunnableTask());
		th.start();}
		System.out.println("Thread details " + Thread.currentThread());

	}

}

class myRunnableTask implements Runnable{

	@Override
	public void run() {
		//System.out.println("Value after addition of 10+5 is " + (10+5));
		System.out.println("Thread details " + Thread.currentThread());
		
	}
	
}
