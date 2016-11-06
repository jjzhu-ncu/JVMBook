package study.hard.jjzhu.source;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PrintHelper {
	public static void showMap(Map<Integer, String> tm){
		Iterator<Entry<Integer, String>> entrySetIter = tm.entrySet().iterator();
		while(entrySetIter.hasNext()){
			Entry<Integer, String> e = entrySetIter.next();
			System.out.println("key:"+e.getKey()+" value:"+e.getValue());
		}

	}
	public static void showMap2(Map<Student, String> tm){
		Iterator<Entry<Student, String>> entrySetIter = tm.entrySet().iterator();
		while(entrySetIter.hasNext()){
			Entry<Student, String> e = entrySetIter.next();
			System.out.println("key:"+e.getKey()+" value:"+e.getValue());
		}

	}
	public static void showEntry(Entry<Integer, String> e){
		System.out.println("key:"+e.getKey()+" value:"+e.getValue());
	}
}	
