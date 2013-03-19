public class OperatorPlus extends Node implements Visitable {

	public OperatorPlus(String val, int c, int l) {

		super(val, c, l);

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}