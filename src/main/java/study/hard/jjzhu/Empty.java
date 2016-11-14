package study.hard.jjzhu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Empty {
	
	public static void main(String[] args) {
		Object[] objArr = new Long[10];
		objArr[1] = "hello world";//ArrayStoreException
		List<HashMap<String, String>> a =  new ArrayList<HashMap<String, String>>();
	}
}









