package study.hard.jjzhu.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
	public static void main(String[] args) {
		MySubject my = new MySubject();
		Subject proxySubject = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(),
				new Class[]{Subject.class},
				new ProxyHandler(my));
		proxySubject.doSomething();
	}
}
