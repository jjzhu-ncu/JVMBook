package study.hard.jjzhu.memory;

/** 
 * @ClassName: JavaVMStackSOF 
 * @Description: 虚拟机栈和本地方法栈OOM测试 
 * @author 祝佳俊(jjzhu_ncu@163.com)
 * @date 2016年10月18日 下午9:09:21 
 *  VM Args: -Xss128k
 */
public class JavaVMStackSOF {
	private int stackLength = 1;
	public void stackLeak(){
		stackLength ++;
		//递归调用
		stackLeak();

	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack deep:" + oom.stackLength);
			throw e;
		}
	}
}
