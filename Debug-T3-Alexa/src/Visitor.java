import java.util.HashMap;
import java.util.Map;


public interface Visitor {

	
	
	
	public void visit(Valoare value);
	public void visit(Variabila variable);
	public void visit(OperatorEgal equal);
	public void visit(OperatorInmultire increase);
	public void visit(OperatorPlus addition);
}