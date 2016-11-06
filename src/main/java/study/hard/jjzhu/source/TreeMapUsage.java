package study.hard.jjzhu.source;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/** 
 * TreeMap的使用示例
 * @author 祝佳俊(jjzhu_ncu@163.com)
 * @date 2016年11月3日 下午4:02:30 
 *  
 */
class MyCmp implements Comparator<Student>{

	public int compare(Student o1, Student o2) {
		if(o1.age > o2.age){
			return 1;
		}else if (o1.age < o2.age){
			return -1;
		}else{
			return o1.name.compareTo(o2.name);
		}
	}
}

class Student{
	String name;
	int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int hashCode(){
		return this.name.hashCode() + age;
	}
	
	public String toString(){
		return "name:"+name+" age:"+age;
	}
}
public class TreeMapUsage {
	
	

	
	public static void main(String[] args) {
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new MyCmp());
		Student s1 = new Student("Lucy", 18);
		Student s2 = new Student("Dive", 19);
		Student s3 = new Student("Kit", 17);
		Student s4 = new Student("Hill", 18);
		tm.put(s1, "A");
		tm.put(s2, "B");
		tm.put(s3, "A");
		tm.put(s4, "C");
		PrintHelper.showMap2(tm);
		
	}
}

/*TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
tm.put(4, "four");
tm.put(1, "one");
tm.put(3, "three");
tm.put(5, "five");
TreeMapUsage.showMap(tm);
System.out.println("最后一个key:"+tm.lastKey());
SortedMap<Integer, String> sm = tm.subMap(2, 5);
TreeMapUsage.showMap(sm);
//第一个
TreeMapUsage.showEntry(tm.ceilingEntry(5));
tm.remove(5);//删除
System.out.println("删除key：5后");
TreeMapUsage.showMap(tm);
String oldValue = tm.put(1, "ONE");
System.out.println("old value:"+oldValue);
System.out.println("更新key：1后");
TreeMapUsage.showMap(tm);
System.out.println("逆序输出");
TreeMapUsage.showMap(tm.descendingMap());*/
