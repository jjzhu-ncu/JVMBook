package study.hard.jjzhu.effectivejava;

import java.util.HashMap;
import java.util.Map;

public class ErasedType {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "你好");
		map.put("how are you?", "吃了没？");
		System.out.println(map.get("hello"));
		System.out.println(map.get("how are you?"));
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(1, "one");
		System.out.println(map2.get(1));
	}
}
