package study.hard.jjzhu;

import java.util.Comparator;

public class Empty {
	
	public static void main(String[] args) {
		Comparator<Integer> myCmp = new Comparator<Integer>(){

			public int compare(Integer first, Integer second) {
				
				return first < second ? -1 : (first == second ? 0 : 1);
			}
			
		};
		Integer a = 42;
		Integer b = 42;
		System.out.println(myCmp.compare(new Integer(42), new Integer(42)));
		System.out.println(myCmp.compare(a, b));
	}
}









