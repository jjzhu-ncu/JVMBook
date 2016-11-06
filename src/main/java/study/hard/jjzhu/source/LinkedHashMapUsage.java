package study.hard.jjzhu.source;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

public class LinkedHashMapUsage {
	public static void main(String[] args) {
		//默认按插入的顺序输出
		LinkedHashMap<Integer, String> lhm  = new LinkedHashMap<Integer, String>();
		lhm.put(1, "Lucy");
		lhm.put(12, "Fic");
		lhm.put(23, "Nick");
		System.out.println("----linked hash map output----");
		PrintHelper.showMap(lhm);
		HashMap<Integer, String> hm  = new HashMap<Integer, String>();
		hm.put(1, "Lucy");
		hm.put(12, "Fic");
		hm.put(23, "Nick");
		System.out.println("----hash map output----");
		PrintHelper.showMap(hm);
		Stack<String> s;
	}
}

