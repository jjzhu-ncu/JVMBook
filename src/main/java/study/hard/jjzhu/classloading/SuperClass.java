package study.hard.jjzhu.classloading;
class My{
	private String name =  "";
}
public class SuperClass {
	static{
		System.out.println("SuperClass init!");
	}
	
	public SuperClass(){
		
	}
}
