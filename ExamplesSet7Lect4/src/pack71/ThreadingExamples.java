package pack71;

public class ThreadingExamples {
	
	public void finalize(){
		System.out.println("Object value was garbage collected.");
	}

	//fixedThreadPool(int qty);
	//new CachedThreadPool();
	public static void main(String[] args) {
		// object which are not ref
		// object with null values
		//destroying unused objects
		//finalize method is internally called by method called gc().
		
		
		ThreadingExamples ob = new ThreadingExamples();
		ThreadingExamples ob2 = new ThreadingExamples();
		ob = null;
		ob2=null;
		new ThreadingExamples();
		//System.gc();
		System.gc();
		
		
		
		
		

	}

}
