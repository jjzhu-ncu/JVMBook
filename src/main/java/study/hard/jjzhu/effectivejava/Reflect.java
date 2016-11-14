package study.hard.jjzhu.effectivejava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
	private int id = 0;
	public Reflect(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	public static void main(String[] args) {
		try {
			
			//Class<?> c = Class.forName("Empty"); // ClassNotFoundException
			Class<?> c = Class.forName("study.hard.jjzhu.effectivejava.Reflect");
			Method method = c.getMethod("setId", int.class);
			method = c.getMethod("setId", int.class);
			method.invoke(c.newInstance(), "abc"); //IllegalArgumentException
			//method = c.getMethod("notSuchMethod"); NoSuchMethodException
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("NoSuchMethodException throwed");
			System.exit(-1);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException throwed");
			System.exit(-1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
