package study.hard.jjzhu.classloading;

public class NotInitialization {
	public static void main(String[] args) {
		/*
		 * SuperClass init!
		 * 123
		 * 对于静态字段，只有直接定义这个字段的类才会被初始化，这里子类引用
		 * 父类中的静态字段value，所以只会触发父类的初始化。
		 */
		//System.out.println(SubClass.value);
		//SuperClass[] sca = new SuperClass[10];
		/*
		 * 输出结果：
		 * 	hello world
		 * 没有输出ConstClass init!
		 * 因为在编译阶段已经将final修饰的“hello world”存储到了
		 * NotInitialization类的常量池中
		 * 堆ConstClass.HELLOWORLD的应用实际上就是对NotInitialization
		 * 类对自身常量池的引用
		 */
		System.out.println(ConstClass.HELLOWORLD);
	}
}
