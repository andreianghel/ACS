
public class Valoare extends Node implements Visitable {

	public Valoare(String val, int c, int l) {
		
		super(val, c, l);
		
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}