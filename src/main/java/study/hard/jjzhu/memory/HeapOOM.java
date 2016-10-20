package study.hard.jjzhu.memory;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: HeapOOM 
* @Description: Java堆内存溢出异常测试
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月18日 下午8:30:13 
* VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
*/
public class HeapOOM {
	static class OOMObject{	
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new  ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
