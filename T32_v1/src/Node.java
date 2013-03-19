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
	public Node calcExpr(Stack<Node> sOp, Stack<Node> sRez)
	{
		Node nRez = sOp.pop();
		
		nRez.refCopii.add(sRez.pop());
		nRez.refCopii.add(0, sRez.pop());
		sRez.push(nRez);
		
		return nRez;
	}

	/**Metoda care initializeaza campurile unei instante;
	 * 
	 * @param tree nodul ce va reprezenta radacina ParseTree;
	 * @param singleLine un boolean ce indica daca fisierul are o singura linie;
	 */
	public void pseudeConstr(Node tree, boolean singleLine)
	{
		this.linie = tree.linie;
		this.col = tree.col;
		
		if(singleLine)
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
	
	/**Metoda ce numara liniile dintr-un fisier;
	 * 
	 * @param inputFile numele fisierului de numarat;
	 */
	public int nrLiniiFisier(String inputFile)
	{
		LineNumberReader lnr = null;
		int l = 0;
		
		try
		{
			lnr = new LineNumberReader(new FileReader(new File(inputFile)));
			lnr.skip(Long.MAX_VALUE);	//apare eroare daca e mai mare decat long.max...ma indoiesc (mai mare decat 2^63 - 1)
			l = lnr.getLineNumber();	//nr de linii din fisier; 
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			try {
				lnr.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return l;
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
					 if(!isOp(aux))	 //valoare sau variabila <-se adauga direct in stiva de rez;
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
							 	 calcExpr(sOp, sRez); //am optimizat algoritmul dat, as fi facut aprox 4 if-uri -> ar fi generat 4 pushOp(if(isEmpty), if(=), if(+), if(*));
						 pushOp(sOp, aux, lnr.getLineNumber(), iCol);	//se ajunge fie daca stiva e vida sau op curent are prioritate mai mica + se termina de calculat prioritatile
					 }
					 iCol += (1 + aux.length());	//se actualizeza indicele col; 
				}
				while(sOp.size() > 0)	//calculez expresiile si construiesc arborele;
					calcExpr(sOp, sRez);
				Node tree = sRez.pop();
				if(nrLiniiFisier(inputFile) == 1)	//nu exista radacina generica;
					this.pseudeConstr(tree, true);
				else
					this.pseudeConstr(tree, false);
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

	/**Metoda ce afiseaza arborele in adancime;
	 * 
	 * @param n nodul de la care se incepe printarea;
	 * @param l int ce reprezinta nivelul de la care initial se porneste, necesar cand se intra in recursivitate pt evidentierea nivelului;
	 */
	public void print(Node n, int l)
	{
		String s = "";
		for(int i = 0; i < l; i++)
			s+="\t";
		System.out.println(s + n.cheie);
		for(Node n1 : n.refCopii)
			n1.print(n1, l+1);
	}
	
	/**Metoda generata de implementarea Visitable;
	 * 
	 * @param v un Visitor;
	 */
	public String accept(Visitor v) 
	{
		return v.visit(this);
	}
}