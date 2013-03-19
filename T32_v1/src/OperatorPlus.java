/**Clasa OperatorPlus;
 * 
 * @author ndr;
 */
public class OperatorPlus extends Node implements Visitable
{
	/**Constructor pt OperatorPlus;
	 * 
	 * @param cheie informatia - +;
	 * @param linie linia din fisier pe care se afla cheia;
	 * @param col coloana din fisier pe care se afla cheia;
	 */
	public OperatorPlus(String cheie, int linie, int col)
	{
		super(cheie, linie, col);
	}
	
	
	public String accept(Visitor v) 
	{
		return v.visit(this);
	}

}