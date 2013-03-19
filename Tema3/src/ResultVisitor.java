import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;


/**Clasa ResultVisitor ce implementeaza Visitor;
 * 
 * @author ndr;
 */
public class ResultVisitor implements Visitor
{
	TreeMap<String, String> dataStruct = new TreeMap<String, String>();	//intrucat HashMap, folosit la Semantic, nu are ordine de inserare, am folosit TreeMap;
	String val, lhsVal, rhsVal;	//valori efective ce se modifica la fiecare accept;
	boolean left, right;	//se folosesc pt operatiile logice;
	
	/**Metoda ce printeaza rezultatele programului introdus;
	 *
	 */
	public void print()
	{	
		TreeMap<String, String> ds = new TreeMap<String, String>();
		NavigableMap<String, String> nmap = dataStruct.descendingMap();
		
		for(Entry<String, String> e : nmap.entrySet())	//inversat dataStruct, si copiat in alt TreeMap doar prima aparitie a unei chei;
			if(!ds.containsKey(e.getKey()))
				ds.put(e.getKey(), e.getValue());
		
		for(String s : ds.keySet())
			System.out.println(s + " = " + ds.get(s));
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
		val = ov.cheie;	//retin valoarea, numar pozitiv sau (true, false);
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param ov un OperandVariabila ce va fi vizitat;
	 */
	@Override
	public void visit(OperandVariabila ov)
	{	
		val = dataStruct.get(ov.cheie);	//retin valoarea, numar pozitiv sau (true, false);
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param oa un OperatorAsterisc ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorAsterisc oa)
	{	//retin valorile, le determin tipurile si le calculez;
		oa.refCopii.get(1).accept(this);
		rhsVal = val;
		oa.refCopii.get(0).accept(this);
		lhsVal = val;
		
		if(SemanticVisitor.isInt(lhsVal))
			val = Integer.toString(Integer.parseInt(lhsVal) * Integer.parseInt(rhsVal));
		else //true sau false
		{
			if(lhsVal.equals("true"))	left = true;
			else						left = false;
			if(rhsVal.equals("true"))	right = true;
			else 						right = false;
			
			val = Boolean.toString(left && right);
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
			dataStruct.put(oa.refCopii.get(0).cheie, val);
	}

	/**Metoda care viziteaza nodul primit ca parametru si il calculeaza, modificand parametrul value;
	 * 
	 * @param op un OperatorPlus ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorPlus op) 
	{	//retin valorile, le determin tipurile si le calculez;	
		op.refCopii.get(1).accept(this);
		rhsVal = val;
		op.refCopii.get(0).accept(this);
		lhsVal = val;
		
		if(SemanticVisitor.isInt(lhsVal))
			val = Integer.toString(Integer.parseInt(lhsVal) + Integer.parseInt(rhsVal));
		else //true sau false
		{
			if(lhsVal.equals("true"))	left = true;
			else						left = false;
			if(rhsVal.equals("true"))	right = true;
			else 						right = false;
		
			val = Boolean.toString(left || right);
		}
	}
}