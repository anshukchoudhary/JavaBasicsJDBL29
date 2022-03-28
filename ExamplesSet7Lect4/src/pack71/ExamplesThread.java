package pack71;

//Line num 11 or 25 which one will excutes first
//always main print statement
//always run print statement
//unpredictable- answer


//thread.run - it will not create a new thread for you
//thread.start - it will create a new thread and call run method internally



class MyThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside thread 123: " + Thread.currentThread());
	}

}

public class ExamplesThread {
	// two ways to create a thread
	// 1) by extending Thread
	// 2) by implementiing the runnable interface
	
	
	//Factors of which the thread scheduling depends on are
	//Priority
	//time of arrival
	
	
	//5threads --------- 5 diff arrival time ------------------ 5 diff priority
	// which one will be picked first
	// thread with the highest priority will be picked first
	// 6th thread arrived it is more priority 
	// then the one of existing thread will preempted and 
	// newely arrived thread will get the cpu time 
	

	public static void main(String[] args) {
	
		MyThread tObj = new MyThread();
		MyThread tObj1 = new MyThread();
		tObj.setName("row1");
		tObj1.setName("row2");
		tObj.setDaemon(true);
		//tObj.start();
		//tObj.interrupt();
		
		tObj1.start();
		//tObj.start(); we can not call start method twice as the thread is already runing it will give u illeagal thread state exception.
		System.out.println("Inside thread 456: " + Thread.currentThread());
		
		
		
	}

}





























///context switching
//processor - 8 cores - 8threads - 
// t1 , t2 ..............................t12,t13
//t13 is high priority thread which arrived
//2nd core was excuting t2 is of low priority
//t2 will preempt and t13 will start to execute and complete then t2 and start to resume the task
//who manages this - schedular.
//in and out of threads between diff core is call context switching

























