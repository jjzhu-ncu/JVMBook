package study.hard.jjzhu.effectivejava;

import java.util.ArrayList;
import java.util.List;

public class Exceptions {
	public static void nullPointException(){
		Integer i = null ;
		System.out.println(i == 0);
	}
	
	public static void indexOutofBoundExp(){
		// empty list
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(list.get(1));
	}
	
	public static void arithmeticExp(){
		System.out.println(1/0);
	}
	public static void numberFormatExp(){
		System.out.println(Integer.parseInt("10s"));
	}
	
	public static void stackOverFlowError(){
		stackOverFlowError(); //递归调用
	}
	
	public static void outOfMemoryError(){
		class Empty{
		}
		List<Empty> list = new ArrayList<Empty>();
		while(true){
			list.add(new Empty());
		}
	}
	public static void classNotFoundExp() {
		try{
			Class.forName("com.Empty");
		}catch( ClassNotFoundException cne){
			cne.printStackTrace();
		}
	}
	
	public static void illegalArgumentExp(){
		class Test{
			public void print(String [] arr){
				if(arr == null){
					throw new IllegalArgumentException("empty array");
				}
			}
		}
		new Test().print(null);
	}
	
	public static void main(String[] args) {
		Exceptions.illegalArgumentExp();
	}
}
