import java.io.*;
import java.util.*;

/**Clasa Node;
 * 
 * @author ndr;
 */
public class Node implements Visitable
{
	String cheie;
	ArrayList<Node> refCopii;
	int linie, col;
	
	/**Constructor pt Node;
	 * 
	 * @param cheie informatia (*, +, =,  true, false, valoare, variabila);
	 * @param linie linia din fisier pe care se afla cheia;
	 * @param col coloana din fisier pe care se afla cheia;
	 */
	public Node(String cheie, int linie, int col)
	{
		this.cheie = cheie;
		this.refCopii = new ArrayList<Node>();
		this.linie = linie;
		this.col = col;
	}
	
	/**Constructor default pt Node;
	 */
	public Node()
	{
		this("", 0 ,0);
	}
	
	/**Metoda ce verifica existenta unui operator;
	 * 
	 * Verifica daca stringul primit este: *, +, =;
	 * 
	 * @param s cheia de verificat;
	 */
	public boolean isOp(String s)	
	{
		return s.equals("*") || s.equals("+") || s.equals("=");
	}
	
	/**Metoda ce verifica existenta unui operand-valoare concreta;
	 * 
	 * Verifica daca stringul primit este: intreg pozitiv: 2, 15 etc., sau boolean: true, false;
     * 
	 * @param s cheia de verificat;
	 */
	public boolean isVal(String s)
	{
		if(s.equals("true") || s.equals("false")) return true;
		else
		{
			for (char c : s.toCharArray())
		        if (!Character.isDigit(c)) return false;
		    return true;
		}
	}
	
	/**Metoda ce va adauga intr-o stiva un operator;
	 * 
	 * @param sOp stiva de operatori in care se va adauga;
	 * @param aux cheia de adaugat;
	 * @param iL indicele liniei corespunzatoare cheii;
	 * @param iCol indicele coloanei corespunzatoare cheii;
	 */
	public void pushOp(Stack<Node> sOp, String aux, int iL, int iCol)
	{
		if(aux.equals("*"))
			 sOp.push(new OperatorAsterisc(aux, iL, iCol));
		if(aux.equals("+"))
		 	 sOp.push(new OperatorPlus(aux, iL, iCol));
		if(aux.equals("="))
			 sOp.push(new OperatorAtribuire(aux, iL, iCol));
	}
	 
	/**Metoda ce verifica relatia dintre operatorul curent si cel din varful stivei;
	 * 
	 * @param sOp stiva de operatori;
	 * @param aux cheia de verificat;
	 * @param crt valoarea ce trebuie comparata cu aux;
	 * @param topStiva elementul din varful stivei;
	 */
	public boolean hasGreaterPriority(Stack<Node> sOp, String aux, String crt, String topStiva)
	{
		return (sOp.peek().cheie.equals(topStiva) && aux.equals(crt));
	}
	
	/**Metoda ce calculeaza o expresie; va fi folosita cand se incearca inserarea unui op cu prioritate mai mica decat cel prezent in capul stivei; 
	 * 
	 * @param sOp stiva de operatori;
	 * @param sRez stiva de rezultate;
	 */
	public void calcExpr(Stack<Node> sOp, Stack<Node> sRez)
	{
		Node nRez = sOp.pop();
		
		nRez.refCopii.add(sRez.pop());
		nRez.refCopii.add(0, sRez.pop());
		sRez.push(nRez);
	}

	/**Metoda care initializeaza campurile unei instante;
	 * 
	 * @param tree nodul ce va reprezenta radacina ParseTree;
	 * @param oneLine un boolean ce indica daca fisierul are o singura linie sau nu;
	 */
	public void pseudeConstr(Node tree, boolean oneLine)
	{
		this.linie = tree.linie;
		this.col = tree.col;
		
		if(oneLine)
		{
			this.cheie = tree.cheie;
			this.refCopii = tree.refCopii;
		}
		else
		{
			this.cheie = "r";
			this.refCopii.add(tree);
		}
	}
	
	/**Metoda ce verifica daca un fisier are o singura linie sau nu;
	 * 
	 * @param inputFile numele fisierului de verificat;
	 */
	public boolean oneLine(String inputFile)
	{
		LineNumberReader lnr = null;
		int i1 = 0;
		
		try
		{
			lnr = new LineNumberReader(new FileReader(new File(inputFile)));
			
			for(int i = 0; i < 2; i++)
				if(lnr.readLine() != null)
					i1++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {	
			try {
					lnr.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		
		if(i1 != 1)
			return false;
		else 
			return true;
	}
	
	/**Metoda ce construieste arborele de parsare;
	 * 
	 * @param inputFile fisierul de intrare;
	 */
	public void parseTree(String inputFile)
	{
		Stack<Node> sRez, sOp;
		String strLine, aux;
		int iCol;
		LineNumberReader lnr = null;
		StringTokenizer st;
		
		try
		{
			lnr = new LineNumberReader(new FileReader(new File(inputFile)));
			
			while((strLine = lnr.readLine()) != null) 	//parcurg pe linii
			{
				sRez = new Stack<Node>();
				sOp = new Stack<Node>();
				
				iCol = 1;
				st = new StringTokenizer(strLine, " ");
				while(st.hasMoreTokens())	//parcurg pe coloane
				{
					 aux = st.nextToken();
					 if(!isOp(aux))	 //valoare sau variabila <- se adauga direct in stiva de rez;
					 {
						 if(isVal(aux))
							 sRez.push(new OperandValoare(aux, lnr.getLineNumber(), iCol));
						 else
							 sRez.push(new OperandVariabila(aux, lnr.getLineNumber(), iCol));
					 }
					 else //isOp: *, +, =
					 { 
						 if(!sOp.isEmpty())
						 	 while(hasGreaterPriority(sOp, aux, "*", "*") || hasGreaterPriority(sOp, aux, "+", "+") || hasGreaterPriority(sOp, aux, "+", "*") || hasGreaterPriority(sOp, aux, "=", "+"))
							 	 calcExpr(sOp, sRez); //am optimizat algoritmul dat, as fi facut aprox 4 if-uri -> ar fi generat 4 pushOp: if(isEmpty), if(=), if(+), if(*);
					
						 pushOp(sOp, aux, lnr.getLineNumber(), iCol);	//se ajunge fie daca stiva e vida sau op curent are prioritate mai mica + se termina de calculat prioritatile
					 }
					 iCol += (1 + aux.length());	//se actualizeza indicele col; 
				}
				while(sOp.size() > 0)	//calculez expresiile si construiesc arborele intermediar;
					calcExpr(sOp, sRez);
				//in sRez ramane un singur nod, care in functie de cate linii are fisierul va fi radacina arborelui final sau va fi adaugat la radacina gerenerica a arborelui final;
				pseudeConstr(sRez.pop(), oneLine(inputFile));	//radacina generica sau nu + legarea arborelui de radacina;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					lnr.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}

	/**Metoda ce afiseaza arborele in adancime pornind de la un nod dat;
	 * 
	 * @param n nodul de la care se incepe printarea;
	 * @param l int ce reprezinta nivelul la care se gaseste cheia, reprezentand multiplicatorul de tab; se incrementeaza cand se intra in recursivitate;
	 */
	public void print(Node n, int l)
	{
		String s = "";
		
		for(int i = 0; i < l; i++)
			s += "\t";
		
		System.out.println(s + n.cheie);
		
		for(Node n1 : n.refCopii)
			n1.print(n1, l+1);
	}
	
	/**Metoda ce printeaza arborele in adancime pornind de la radacina;
	 * 
	 */
	public void print()
	{
		print(this, 0);
	}
	
	/**Metoda generata de implementarea Visitable;
	 * 
	 * @param v un Visitor;
	 */
	public void accept(Visitor v) 
	{
		v.visit(this);
	}
}