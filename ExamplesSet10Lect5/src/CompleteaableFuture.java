import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompleteaableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		ExecutorService es = Executors.newFixedThreadPool(5);
		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> {
		
			return "List of names";
		}).thenApply(names -> names + "i am from earth");
		// .thenAccept(name-> name+)
		String val = cFuture.get();
		//after some time out if it doesnot respond
		System.out.println(cFuture.complete("this method was stuck......."));
		//System.out.println("hi every one :" + val);
	

	}

}
