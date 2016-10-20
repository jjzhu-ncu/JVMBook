package study.hard.jjzhu.memory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
* @ClassName: JavaMethodAreaOOM 
* @Description: 方法区内存溢出异常 
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月18日 下午9:29:32 
* VM Args: -XX:PermSize=5M -XX:MaxPermSize=5M
*/
public class JavaMethodAreaOOM {
	static class OOMObject{}
	public static void main(String[] args) {
		while(true){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor(){

				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					
					return proxy.invoke(obj, args);
				}
				
			});
			enhancer.create();
		}
	}
}
