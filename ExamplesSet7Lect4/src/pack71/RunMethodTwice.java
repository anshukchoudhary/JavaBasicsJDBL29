package pack71;



//Daemon thread - examples are gc , finalize
//these are used for background supporting task such as garbage collection
//clean memory
//jvm thread Daemon thread
class MyThread1 extends Thread {

	@Override
	public void run() {

		for (int i = 1; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Inside thread 12356: " + Thread.currentThread());
	}

}
// 


public class RunMethodTwice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		MyThread1 th = new MyThread1();
		MyThread1 th2 = new MyThread1();
		//th.setDaemon(true);
		//Thread.currentThread().setDaemon(true);
		//th.setPriority(122);
		//th.setName("Abhinay's thread");
		//th.setPriority(11);
		
		th.start();
		
		th2.start();
		th.join();
		

	}

}
