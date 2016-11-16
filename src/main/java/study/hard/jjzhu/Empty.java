package study.hard.jjzhu;

public class Empty {
	private class C{
		int []c = {1, 2 , 3 , 4, 5};
		
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder(c.length);
			for(int _ : c){
				sb.append(String.valueOf(_));
			}
			return sb.toString();
		}
	}
	public void m1(){
		C c = new C();
		m2(c);
		System.out.println(c);
	}
	public void m2(C c){
		c.c[1] = 3;
	}
	public static void main(String[] args) {
		new Empty().m1();
	}
}









