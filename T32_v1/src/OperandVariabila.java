/**Clasa OperandVariabila;
 * 
 * @author ndr;
 */
public class OperandVariabila extends Node implements Visitable
{
	/**Constructor pt OperandVariabila;
	 * 
	 * @param cheie informatia - variabila;
	 * @param linie linia din fisier pe care se afla cheia;
	 * @param col coloana din fisier pe care se afla cheia;
	 */
	public OperandVariabila(String cheie, int linie, int col)
	{
		super(cheie, linie, col);
	}
	
	
	public String accept(Visitor v) 
	{
		return v.visit(this);
	}
}