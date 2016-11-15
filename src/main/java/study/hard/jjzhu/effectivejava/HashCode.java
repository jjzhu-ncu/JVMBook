package study.hard.jjzhu.effectivejava;

import java.util.Arrays;

public class HashCode {
	public static int stringHashCode(String str){
		if(str == null || str.equals("")){
			return 0;
		}
		int result = 17;
		char [] chars = str.toCharArray();
		for(char c: chars){
			result = result * 31 + c; 
		}
		return result;
		
	}
	public static int booleanHashCode(boolean value){
		int result = 17;
		return result * 31 + (value?1:0);
	}
	public static int floatHashCode(float value){
		int result = 17;
		int c = Float.floatToIntBits(value);
		return result * 31 + c; 
	}
	public static int doubleHashCode(double value){
		int result = 17;
		long f = Double.doubleToLongBits(value);
		int c = (int)(f ^ (f >>> 32));
		return result*31 + c;
	}
	public static int intArrayHashCode(int[] arr){
		int result = 17;
		int c = Arrays.hashCode(arr);
		return result*31 + c;
	}
	
	public static void main(String[] args) {
		System.out.println(HashCode.stringHashCode("jjzh1"));
		System.out.println(HashCode.booleanHashCode(true));
		System.out.println(HashCode.floatHashCode(.01234f));
		System.out.println(HashCode.doubleHashCode(.01234d));
		System.out.println(HashCode.intArrayHashCode(new int[]{1, 2, 3}));
		
	}
}
