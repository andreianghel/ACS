public class OperatorInmultire extends Node implements Visitable{

	public OperatorInmultire(String val, int c, int l) {
		
		super(val, c, l);

	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}