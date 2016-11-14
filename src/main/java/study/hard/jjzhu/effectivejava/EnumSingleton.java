package study.hard.jjzhu.effectivejava;

public enum EnumSingleton {
	INSTANCE;
	public void print(String s){
		System.out.println("hello " + s);
	}
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.print("world");
	}
}
