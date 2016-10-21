package study.hard.jjzhu.collection;

/** 
* @ClassName: FinalizeEscapeGC 
* @Description: 对象的自我拯救 
* 		对象可以在被GC的时候自我拯救
* 		机会只有一次，因为每个对象的finalize()方法最多只会被系统自动调用一次
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月20日 下午5:08:27 
*  
*/
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	public void isAlive(){
		System.out.println("yes, I am still alive :)");
	}
	
	//只会在GC的时候调用一次
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this; //自我救赎
	}
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am dead :(");
		}
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am dead :(");
		}
	}
}
