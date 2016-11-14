package study.hard.jjzhu.effectivejava.enum_;

public enum ExtendedOperation implements Operation {
	EXP("^"){
		public double apply(double x, double y){
			return Math.pow(x, y);
		}
	};
	private final String symobl;
	private ExtendedOperation(String symbol){
		this.symobl = symbol;
	}
	
	@Override
	public String toString(){
		return this.symobl;
	}

}
