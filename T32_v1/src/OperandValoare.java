/**Clasa OperandValoare;
 * 
 * @author ndr;
 */
public class OperandValoare extends Node implements Visitable
{
	/**Constructor pt OperandValoare;
	 * 
	 * @param cheie informatia - valoare;
	 * @param linie linia din fisier pe care se afla cheia;
	 * @param col coloana din fisier pe care se afla cheia;
	 */
	public OperandValoare(String cheie, int linie, int col)
	{
		super(cheie, linie, col);
	}
	
	
	public String accept(Visitor v) 
	{
		return v.visit(this);
	}
}