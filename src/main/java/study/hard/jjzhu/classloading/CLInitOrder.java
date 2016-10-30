package study.hard.jjzhu.classloading;

public class CLInitOrder {
	/*
	 * 父类的初始化优先于自子类的初始化
	 */
	static class Parent{
		public static int A = 1;
		static{
			A = 2;
		}
	}
	
	static class Sub extends Parent{
		public static int B = A;
	}
	
	public static void main(String[] args) {
		//输出2
		System.out.println(Sub.B);
	}
}	
