package study.hard.jjzhu.classloading;

public class SubClass extends SuperClass {
	static{
		System.out.println("SubClass init!");
	}
	public static int value = 123;
	private My my = new My();


	public static void main(String[] args) {
		Object obj = new Object();
		obj = new SuperClass();
		SubClass sc = new SubClass();
		SuperClass s = new SuperClass(); 
		s = sc;
	}
}
