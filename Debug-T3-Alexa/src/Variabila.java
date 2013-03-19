
public class Variabila extends Node implements Visitable{

	public Variabila(String val, int c, int l) {
		super(val, c, l);
		
		
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}