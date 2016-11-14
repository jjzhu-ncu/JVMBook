package study.hard.jjzhu.effectivejava;

public class Equals {
	private  class CaseInsensitiveString{
		private String s;
		public  CaseInsensitiveString(final String str) {
			this.s = str;
		}
		/*@Override 
		public boolean equals(Object obj){
			if(obj instanceof CaseInsensitiveString){
				return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
			}
			if(obj instanceof String){
				return s.equalsIgnoreCase((String)obj);
			}
			return false;
		}*/
		@Override
		public boolean equals(Object o){
			return (o instanceof CaseInsensitiveString) && ((CaseInsensitiveString) o).s.equalsIgnoreCase(this.s);
		}
	}
	
	public  void test(){
		Object x = new CaseInsensitiveString("abcef");
		Object y = "Abcd";
		System.out.println(x.equals(y));//1
		System.out.println(y.equals(x));//0
	}
	public static void main(String[] args) {
		System.out.println(null instanceof String);
	}
}
