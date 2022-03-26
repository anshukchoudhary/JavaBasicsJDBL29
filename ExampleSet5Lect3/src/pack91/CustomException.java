package pack91;

public class CustomException extends RuntimeException {

	public CustomException(String msg) {
		super(msg);
		System.out.println(msg);
	}

}
