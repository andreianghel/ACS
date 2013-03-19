public class OperatorEgal extends Node implements Visitable {

	public OperatorEgal(String val, int c, int l) {

		super(val, c, l);

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}