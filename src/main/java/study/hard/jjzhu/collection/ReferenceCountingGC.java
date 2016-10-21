package study.hard.jjzhu.collection;

/** 
* @ClassName: ReferenceCountingGC 
* @Description: 引用计算GC 
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月20日 下午4:57:53 
*  
*/
public class ReferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	private byte[] bigSize = new byte[2 * _1MB];
	public static void testGC(){
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB; //互相引用
		objB.instance = objA;
		objA = null;
		objB = null;
		
		System.gc();
	}
	public static void main(String[] args) {
		testGC();
	}
}
