package study.hard.jjzhu.gc;

/** 
* @ClassName: GrabageCollection 
* @Description: 测试各种GC收集器
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月20日 下午5:26:49 
*  
*/
public class GrabageCollection {
	private static final int _1MB = 1024 * 1024;
	/*
	 * VM args: -verbose:gc -Xms20M -Xmx20M -XX:SurvivorRatio=8
	 * 给JAVA堆分配了20MB， 10MB给新生代，10MB给老年代
	 * 新生代中Eden区8M， from space 1M, to space 1M
	 */
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[2 * _1MB] ;
		allocation2 = new byte[2 * _1MB] ;
		allocation3 = new byte[2 * _1MB] ; 
		allocation4 = new byte[4 * _1MB] ; //出现一次Minor GC，因为Eden去已经没有足够的空间了(8-6)=2MB
	}
	/*
	 * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC
	 */
	public static void testPretenureSizeThreshold(){
		byte [] allocation;
		allocation = new byte[4*_1MB];
	}
	/*
	 * 长期存活的对象将进入老年代
	 * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 * -XX:+UseParNewGC -XX:+PrintGCDetails
	 */
	public static void testTenuringThreshold(){
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];  //256K
		allocation2 = new byte[4 * _1MB];  //4*1024=4096
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}
	/*
	 * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 * -XX:+UseParNewGC -XX:+PrintGCDetails
	 */
	public static void testTenuringThreshold2(){
		byte[] allocation_265KB_1,allocation_265KB_2, allocation_4MB_1, allocation_4MB_2;
		allocation_265KB_1 = new byte[_1MB / 4];
		//allocation_265KB_2 = new byte[_1MB / 4];
		allocation_4MB_1 = new byte[4 * _1MB];
		allocation_4MB_2 = new byte[4 * _1MB];
		allocation_4MB_2 = null; //Minor 会触发GC
		allocation_4MB_2 = new byte[4 * _1MB];
	}
	/*
	 * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
	 */
	public static void testHandlePromotion(){
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation1 = null;
		allocation4 = new byte[2 * _1MB];
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * _1MB];
	}
	
	public static void main(String[] args) {
		//testAllocation();
		//testPretenureSizeThreshold();
		//testTenuringThreshold();
		//testTenuringThreshold2();
		testHandlePromotion();
	}
}
