package study.hard.jjzhu.memory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/** 
* @ClassName: DirectMemoryOOM 
* @Description:  本机直接内存溢出
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月18日 下午9:41:40 
* VM Args: -Xmx20M -XX:MaxDirectMemorySize=20M
*/
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe)unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}
}
