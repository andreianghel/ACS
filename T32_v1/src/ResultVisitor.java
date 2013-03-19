import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;


/**Clasa ResultVisitor ce implementeaza Visitor;
 * 
 * @author ndr;
 */
public class ResultVisitor implements Visitor
{
	TreeMap<String, String> dataStruct = new TreeMap<String, String>();	//se pare ca HashMap, folosit la Semantic, nu are ordine in sine, dar TreeMap are;
	String value, lhsValue, rhsValue;	//valori efective ce se modifica la fiecare accept;
	boolean left, right;	//se folosesc pt operatiile logice;
	
	/**Metoda ce printeaza rezultatele programului introdus;
	 *
	 */
	public void print()
	{	
		TreeMap<String, String> ds = new TreeMap<String, String>();
		NavigableMap<String, String> nmap = dataStruct.descendingMap();
		
		for(Entry<String, String> e : nmap.entrySet())	//inversat dataStruct, si copiat in alt treeMap doar prima aparitie a unei chei;
			if(!ds.containsKey(e.getKey()))
				ds.put(e.getKey(), e.getValue());
		
		for(Entry<String, String> e : ds.entrySet())
			System.out.println(e.getKey() + " = " + e.getValue());
	}
	
	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param n un Node ce va fi vizitat;
	 */
	@Override
	public void visit(Node n) 
	{
		//din nou, aceasta metoda nu se foloseste; 
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param ov un OperandValoare ce va fi vizitat;
	 */
	@Override
	public void visit(OperandValoare ov) 
	{
		value = ov.cheie;
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param ov un OperandVariabila ce va fi vizitat;
	 */
	@Override
	public void visit(OperandVariabila ov)
	{	
		value = dataStruct.get(ov.cheie);
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param oa un OperatorAsterisc ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorAsterisc oa)
	{	//retin valorile, le determin tipurile si le calculez;
		oa.refCopii.get(1).accept(this);
		rhsValue = value;
		oa.refCopii.get(0).accept(this);
		lhsValue = value;
		
		if(SemanticVisitor.isInt(lhsValue))
			value = Integer.toString(Integer.parseInt(lhsValue) * Integer.parseInt(rhsValue));
		else //true sau false
		{
			if(lhsValue.equals("true"))	left = true;
			else						left = false;
			if(rhsValue.equals("true"))	right = true;
			else 						right = false;
		
			value = Boolean.toString(left && right);
		}
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param oa un OperatorAtribuire ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorAtribuire oa)
	{	
		oa.refCopii.get(1).accept(this);	//accept pe dreapta si obtin o valoare;
											//pe care o atribui variabilei din stanga, si o depun in dataStruct;
		if(!dataStruct.containsKey(oa.refCopii.get(0).cheie))
			dataStruct.put(oa.refCopii.get(0).cheie, value);
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param op un OperatorPlus ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorPlus op) 
	{	//retin valorile, le determin tipurile si le calculez;	
		op.refCopii.get(1).accept(this);
		rhsValue = value;
		op.refCopii.get(0).accept(this);
		lhsValue = value;
		
		if(SemanticVisitor.isInt(lhsValue))
			value = Integer.toString(Integer.parseInt(lhsValue) + Integer.parseInt(rhsValue));
		else //true sau false
		{
			if(lhsValue.equals("true"))	left = true;
			else						left = false;
			if(rhsValue.equals("true"))	right = true;
			else 						right = false;
		
			value = Boolean.toString(left || right);
		}
	}
}