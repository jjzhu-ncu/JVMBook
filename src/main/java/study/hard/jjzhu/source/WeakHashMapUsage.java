package study.hard.jjzhu.source;

import java.util.HashSet;
import java.util.WeakHashMap;

public class WeakHashMapUsage {
	public static boolean isNormal(Long year, Long month, Long day){
		boolean isLeapYear = false;
		boolean isBigMonth = false;
		int [] bigMonths = {1, 3, 5, 7, 8, 10, 12};
		for(int i=0;i<bigMonths.length;i++){ //
			if(bigMonths[i] == month){
				isBigMonth = true;
				break;
			}
		}
		//小月 31号
		if(!isBigMonth && day == 31){
			return false;
		}
		

		return true;

	}
	public static void main(String[] args) {
		WeakHashMap<Integer, String> whm ;
		HashSet<String> hs ;
		System.out.println(WeakHashMapUsage.isNormal(2008l, 4l, 31l));
	}
}
