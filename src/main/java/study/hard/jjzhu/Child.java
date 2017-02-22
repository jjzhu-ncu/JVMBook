package study.hard.jjzhu;

public class Child extends Parent implements Interface1{

	public void fun() {
		System.out.println("fun");
		
	}

	@Override
	public void fun2() {
		
		System.out.println("fun2");
	}

}
