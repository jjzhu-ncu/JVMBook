package study.hard.jjzhu.memory;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: RuntimeConstantPoolOOM 
 * @Description: 方法区和运行时常量池溢出
 * @author 祝佳俊(jjzhu_ncu@163.com)
 * @date 2016年10月18日 下午9:18:07 
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0 ;
		while(true){
			/* 
			 * String.intern()是一个Native方法，作用是:如果字符串常量池中已经包含一个等价于此String
			 * 对象的字符串，则返回常量池中这个字符串的String对象，否则，将此String对象包含的字符串添加到常量池中，
			 * 并返回此String对象的引用
			*/
			list.add(String.valueOf(i++).intern());
		}
	}
}
