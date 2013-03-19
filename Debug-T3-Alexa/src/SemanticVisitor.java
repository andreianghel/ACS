import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SemanticVisitor implements Visitor {

	TreeMap<String, String> dictionary = new TreeMap<String, String>();
	String type;

	@Override
	public void visit(Valoare value) {
		if(value instanceof Valoare)	System.out.println(value + ": valoare: da");
	if (value.value.equals("true") || value.value.equals("false")) 
			type = "boolean";
		else
			type = "integer";
	}

	public void visit(Variabila variable) {
		//System.out.println("visit variabila: "+variable.value);
		if(variable instanceof Variabila)	System.out.println(variable + ": variabila: da");
		
		if (!dictionary.containsKey(variable.value))
		{	System.out.println(variable.value + " nedeclarata la linia "
					+ variable.line + " coloana " + variable.column);
		 type="gresit";
		}
		else
			{type = dictionary.get(variable.value);
			// System.out.println("variable-----"+variable.value);
			}
	}

	@Override
	public void visit(OperatorEgal equal) {
		//System.out.println("visit egal");
		equal.kid.get(1).accept(this);
		if (!(equal.kid.get(0) instanceof Variabila)) {
			System.out.println("membrul stang nu este o variabila la linia "
					+ equal.kid.get(0).line + " coloana "
					+ equal.kid.get(0).column);
			type="gresit";
		} else 
			if (!type.equals("gresit"))
						dictionary.put(equal.kid.get(0).value,type);
	}

	@Override
	public void visit(OperatorInmultire increase) {
		increase.kid.get(0).accept(this);
		String typeaux=type;
		increase.kid.get(1).accept(this);
		if(!typeaux.equals(type) && !(type.equals("gresit") || typeaux.equals("gresit")))
		{	System.out.println("* intre tipuri incompatibile la linia "+increase.line+" coloana "+increase.column);
		    type="gresit";
		//    System.out.println("increase: "+increase.value);
		}
		//System.out.println("visit inmultire");
	}

	@Override
	public void visit(OperatorPlus addition) {
		//System.out.println("visit adunare");
		addition.kid.get(0).accept(this);
		String typeaux=type;
		addition.kid.get(1).accept(this);
		if(!typeaux.equals(type) && !(type.equals("gresit") || typeaux.equals("gresit")))
		{	System.out.println("+ intre tipuri incompatibile la linia "+addition.line+" coloana "+addition.column);
		    type="gresit";
		 //   System.out.println("addition "+addition.value);
		}
	}
}