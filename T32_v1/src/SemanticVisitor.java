import java.util.*;

/**Clasa SemanticVisitor ce implementeaza Visitor;
 * 
 * @author ndr;
 */
public class SemanticVisitor implements Visitor
{	//retin intr-un tabel nodul si tipul sau: String1: cheia nodului (operand || operator) + String2: tipul op.;
	Map<String, String> dataStruct = new HashMap<String, String>();	
	
	/*"The idea is that when the visitor visits an expression, then it returns the type of that expression.
	     If the expression does not type-check, then the type-check is terminated with an error message."*/
	
	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param ov un OperandValoare ce va fi vizitat;
	 */
	@Override
	public String visit(OperandValoare ov)
	{	// valoare: numar pozitiv sau (true, false)-> asociem un tip;
		if(isInt(ov.cheie))
				return "int";
		else
				return "bool";
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param ov un OperandVariabila ce va fi vizitat;
	 */
	@Override
	public String visit(OperandVariabila ov)
	{
		//if(!tip.equals("null")) //sau daca tipul nu e null (pt cazurile rare, in care a fost adaugat in struct avand cheie nula)
		if(dataStruct.containsKey(ov.cheie)) //setez tipul: daca exista in struct;
			return dataStruct.get(ov.cheie);
		else //nu exista<-semnalez eroare;
		{
			System.out.println(ov.cheie + " nedeclarata la linia " + ov.linie + " coloana " + ov.col);
			dataStruct.put(null, "null"); //semnalez ca programul este incorect; hashMap permite existenta unei singure chei nule;
			return "null";
		}
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param oa un OperatorAsterisc ce va fi vizitat;
	 */
	@Override
	public String visit(OperatorAsterisc oa)
	{
			String ls = oa.refCopii.get(0).accept(this);
			//retinem tipul intrucat cand apelez pt rightHandSide, tipul se modifica -> trebuie sa compar tipurile;
			String rs = oa.refCopii.get(1).accept(this);
			
			//nu intereseaza: daca tipurile sunt egale<- expr corecta sau daca vreunul e "null"<- a fost semnalata eroarea deja
			if(!ls.equals(rs))
				if(!(ls.equals("null") || rs.equals("null")))
				{
					System.out.println("* intre tipuri incompatibile la linia " + oa.linie + " coloana " + oa.col);
					dataStruct.put(null, "null");
					return "null";
				}
			return ls;
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param oa un OperatorAtribuire ce va fi vizitat;
	 */
	@Override
	public String visit(OperatorAtribuire oa) 
	{	//am facut accept pe dreapta mai intai pt ca asa reiesea din tester;
		String rs = oa.refCopii.get(1).accept(this); //rhs accept(this)-> v.visit(rhs); -> nu stiu tipul rhs, in dreapta pot avea orice;
		
		//fiind atribuire, membrul stang trebuie sa fie o variabila; (ex propus era: 5 = a) + faptul ca expresiile sunt corecte;
		if(oa.isVal(oa.refCopii.get(0).cheie))	//daca am valoare in stanga, semnalez eroare;
		{
			System.out.println("membrul stang nu este o variabila la linia " + oa.refCopii.get(0).linie + " coloana " + oa.refCopii.get(0).col);
			dataStruct.put(null, "null"); 
		}
		else
			//pt ca "=" va fi intodeauna prima operatie in arbore aici se "link"-eaza tipul variabilelor;
			if(!rs.equals("null")) //se adauga tipul in dataStruct;
				dataStruct.put(oa.refCopii.get(0).cheie, rs);
		return "";
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param op un OperatorPlus ce va fi vizitat;
	 */
	@Override
	public String visit(OperatorPlus op) 
	{
		String ls = op.refCopii.get(0).accept(this);
		//retinem tipul intrucat cand apelez pt rightHandSide, tipul se modifica -> trebuie sa compar tipurile;
		String rs = op.refCopii.get(1).accept(this);
		
		//nu intereseaza: daca tipurile sunt egale<- expr corecta sau daca vreunul e "null"<- a fost semnalata eroarea deja
		if(!ls.equals(rs))
			if(!(ls.equals("null") || rs.equals("null")))
			{
				System.out.println("* intre tipuri incompatibile la linia " + op.linie + " coloana " + op.col);
				dataStruct.put(null, "null");
				return "null";
			}
		return ls;
}

	/**Metoda care nu face nimic;
	 * 
	 * @param n un nod;
	 */
	@Override
	public String visit(Node n)
	{
		/*nu e folosit, generat de legaturi si implementari; a pornit de la x.refCopii.accept(this);
		* refCopii = List<Node>, aveam nevoie de un accept pe Node-> clasa Node a implementat Visitable -> ...etc*/
		return "";
	}
	
	/**Metoda ce verifica daca un string este un numar;
	 * 
	 * @param s stringul de verificat;
	 * @return un boolean: true-este numar; false altfel;
	 */
	public static boolean isInt(String s)
	{
		for (char c : s.toCharArray())
	        if (!Character.isDigit(c)) return false;
	    return true;
	}
}