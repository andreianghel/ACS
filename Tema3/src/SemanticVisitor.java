import java.util.*;

/**Clasa SemanticVisitor ce implementeaza Visitor;
 * 
 * @author ndr;
 */
public class SemanticVisitor implements Visitor
{	//retin intr-un tabel cheia nodului si tipul nodului;
	HashMap<String, String> dataStruct = new HashMap<String, String>();	
	String tip = "", lhsTip = "";
	
	/*"The idea is that when the visitor visits an expression, then it returns the type of that expression.
	     If the expression does not type-check, then the type-check is terminated with an error message."*/
	
	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param ov un OperandValoare ce va fi vizitat;
	 */
	@Override
	public void visit(OperandValoare ov)
	{	// valoare: numar pozitiv sau (true, false)-> asociem un tip;
		if(isInt(ov.cheie))
				tip = "int";
		else
				tip = "bool";
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param ov un OperandVariabila ce va fi vizitat;
	 */
	@Override
	public void visit(OperandVariabila ov)
	{	//aceasta metoda se apeleaza cand o variabila apare in dreapta semnului "=";
		//if(!tip.equals("null")) //sau daca tipul nu e null;
		if(dataStruct.containsKey(ov.cheie)) //cheia exista in struct (a aparut in prealabil in stanga "="): iau tipul din dataStruct;
			tip = dataStruct.get(ov.cheie);
		else //nu exista<-semnalez eroare;
		{
			System.out.println(ov.cheie + " nedeclarata la linia " + ov.linie + " coloana " + ov.col);
			tip = "null";
			dataStruct.put(null, "null"); //semnalez ca programul este incorect; hashMap permite existenta unei singure chei nule;
		}
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param oa un OperatorAsterisc ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorAsterisc oa)
	{
			oa.refCopii.get(0).accept(this);
			lhsTip = tip;	//retin tipul intrucat cand apelez pt rightHandSide, tipul se modifica -> trebuie sa compar tipurile;
			oa.refCopii.get(1).accept(this);
			
			if(!lhsTip.equals(tip))		//nu intereseaza: tipurile sunt egale<- expr corecta; 
				if(!(lhsTip.equals("null") || tip.equals("null")))	//vreunul e "null"<- a fost semnalata eroarea deja;
				{
					System.out.println("* intre tipuri incompatibile la linia " + oa.linie + " coloana " + oa.col);
					tip = "null";
					dataStruct.put(null, "null");
				}
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param oa un OperatorAtribuire ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorAtribuire oa) 
	{	//am facut accept pe dreapta mai intai pt ca asa reiesea din tester;
		oa.refCopii.get(1).accept(this); //rhs accept(this)-> v.visit(rhs); -> nu stiu tipul rhs, in dreapta pot avea orice;
		
		//fiind atribuire, membrul stang trebuie sa fie o variabila; (ex propus era: 5 = a) + faptul ca expresiile sunt corecte;
		if(oa.isVal(oa.refCopii.get(0).cheie))	//daca am valoare in stanga, semnalez eroare;
		{
			System.out.println("membrul stang nu este o variabila la linia " + oa.refCopii.get(0).linie + " coloana " + oa.refCopii.get(0).col);
			dataStruct.put(null, "null"); 
		}
		else
		{	//pt ca "=" va fi intodeauna prima operatie in arbore aici se "link"-eaza tipul variabilelor;
			if(tip.equals("int")) //se adauga tipul in dataStruct;
				dataStruct.put(oa.refCopii.get(0).cheie, "int");
			else if(tip.equals("bool"))
					  dataStruct.put(oa.refCopii.get(0).cheie, "bool");
		}
	}

	/**Metoda care viziteaza nodul primit ca parametru si verifica corectitudinea lui;
	 * 
	 * @param op un OperatorPlus ce va fi vizitat;
	 */
	@Override
	public void visit(OperatorPlus op) 
	{
			op.refCopii.get(0).accept(this);
			lhsTip = tip;	//retin tipul intrucat cand apelez pt rhs, tipul se modifica -> trebuie sa compar tipurile;
			op.refCopii.get(1).accept(this);
			
			if(!lhsTip.equals(tip))		//nu intereseaza: tipurile sunt egale<- expr corecta; 
				if(!(lhsTip.equals("null") || tip.equals("null")))	//vreunul e "null"<- a fost semnalata eroarea deja;
				{
					System.out.println("+ intre tipuri incompatibile la linia " + op.linie + " coloana " + op.col);
					tip = "null";
					dataStruct.put(null, "null");
				}
	}

	/**Metoda care nu face nimic;
	 * 
	 * @param n un nod;
	 */
	@Override
	public void visit(Node n)
	{
		/*nu e folosit, generat de legaturi si implementari; a pornit de la x.refCopii.accept(this);
		* refCopii = List<Node>, aveam nevoie de un accept pe Node-> clasa Node a implementat Visitable -> ...etc*/
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