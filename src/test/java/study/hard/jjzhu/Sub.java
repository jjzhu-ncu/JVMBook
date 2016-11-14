package study.hard.jjzhu;

public class Sub extends Super{
	public Sub(){
		System.out.println("sub init");
	}
	public void a(){
		System.out.println(IntenalClass.name);;
	}
	private static class IntenalClass{
		static final String name = "jjzhu";
	}
	
	public static void main(String [] args){
		Integer.parseInt("aaa");
	}
}
