package study.hard.jjzhu.classloading;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader myLoader = new ClassLoader(){
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try{
					String fileName = name.substring(name.lastIndexOf(".")+1) +".class";
					
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null){
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				}catch(IOException e){
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myLoader.loadClass("study.hard.jjzhu.classloading.ClassLoaderTest");
		System.out.println(obj.getClass());
		// 为false
		System.out.println(obj instanceof study.hard.jjzhu.classloading.ClassLoaderTest);
	}
}
