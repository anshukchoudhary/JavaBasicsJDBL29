package Doubts;
//Problem here is that you can't store reference to object of superclass in variable of its derived type.'

class Child extends Parent {
	private int i;

	public void setI(int i) {
		this.i = i;
	}

	public static void main(String[] args) {
		Child b = (Child) new Parent();
		
		b.setI(4);
		
	}
}