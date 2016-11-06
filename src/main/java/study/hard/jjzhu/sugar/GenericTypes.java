package study.hard.jjzhu.sugar;

//-XX:AutoBoxCacheMax=400
public class GenericTypes {
	public static void main(String[] args) {
		Boolean b1 = true;
		Boolean b2 = true;
		
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
		
		Character c1 = 'a';
		Character c2 = 'a';
		System.out.println(c1 == c2);
		
		Float f1 = 0.1f;
		Float f2 = 0.1f;
		System.out.println(f1 == f2);
		
		Long l1 = 10L;
		Long l2 = 10L;

		Long l3 = 210L;
		Long l4 = 210L;
		System.out.println(l1 == l2);
		System.out.println(l3 == l4);
	}
}
