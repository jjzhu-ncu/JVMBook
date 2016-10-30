package study.hard.jjzhu.bitecode;

import java.io.Serializable;

public class Overload {
	public static void sayHello(Object arg){
		System.out.println("hello object");
	}
	public static void sayHello(int arg){
		System.out.println("hello int");
	}
	
	public static void sayHello(long arg){
		System.out.println("hello long");
	}
	
	public static void sayHello(Character arg){
		System.out.println("hello Character");
	}
	public static void sayHello(char arg){
		System.out.println("hello char");
	}
	public static void sayHello(char ... arg){
		System.out.println("hello char ...");
	}
	public static void sayHello(Serializable arg){
		System.out.println("hello serializable");
	}
	public static void sayHello(Comparable<Character> arg){
		System.out.println("hello comparable");
	}
	public static void main(String[] args) {
		sayHello((Comparable<Character>)'a');
	}
}
