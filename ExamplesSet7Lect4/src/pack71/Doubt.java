package pack71;

public class Doubt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 
 It is possible to increase heap size allocated by the JVM by using command line options Here we have 3 options
 -Xms<size>        set initial Java heap size
-Xmx<size>        set maximum Java heap size
-Xss<size>        set java thread stack size

java -Xms16m -Xmx64m ClassName

How many threads can a Java VM support?
This depends on the CPU you're using, on the OS, on what other processes are doing, on what Java release you're using, and other factors. I've seen a Windows server have > 6500 Threads before bringing the machine down. Most of the threads were not doing anything, of course. Once the machine hit around 6500 Threads (in Java), the whole machine started to have problems and become unstable.
My experience shows that Java (recent versions) can happily consume as many Threads as the computer itself can host without problems.
Of course, you have to have enough RAM and you have to have started Java with enough memory to do everything that the Threads are doing and to have a stack for each Thread. Any machine with a modern CPU (most recent couple generations of AMD or Intel) and with 1 - 2 Gig of memory (depending on OS) can easily support a JVM with thousands of Threads.



Doubt1
how many thread you can create in 1 tb storage 
https://dzone.com/articles/java-what-limit-number-threads
https://dzone.com/articles/how-much-memory-does-a-java-thread-take - also compare info between java8 and java11 thread memory consumption
drill down

 
Doubt2
context switicing performace impact ?
please go through all the quesiton in below link 
very helpful and informative resource and explainatory
https://firstlawcomic.com/does-context-switching-improve-performance/

Doubt3
Signigficance of defining a user thread as daemon thread.
List of usecase when you may want to use a user created daemon thread:
1) Collecting statistics and performing the status monitoring tasks - Sending and receiving network heartbeats, supplying the services to monitoring tools, and so on.
2) Performing asynchronous I/O tasks - You can create a queue of I/O requests, and set up a group of daemon threads servicing these requests asynchronously.
3) Listening for incoming connections - daemon threads are very convenient in situations like this, because they let you program a simple "forever" loop, rather than creating a setup that pays attention to exit requests from the main thread.
*/