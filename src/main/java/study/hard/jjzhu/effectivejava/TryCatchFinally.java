package study.hard.jjzhu.effectivejava;

import java.util.List;

public class TryCatchFinally {
	public static void div(){
		int x = 1;
		int y = 1;
		List<String> nullList = null;
		try{
			System.out.println(y/x);
			nullList.add("hellow");
		}catch(ArithmeticException ae){
			System.out.println("/ by zero");
		}finally{
			System.out.println("finally block");
		}
		System.out.println("outside of try-catch block");
	}

	public static void main(String[] args) {
		TryCatchFinally.div();
	}
}
