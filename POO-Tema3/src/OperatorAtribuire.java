/**Clasa OperatorAtribuire;
 * 
 * @author ndr;
 */
public class OperatorAtribuire extends Node implements Visitable
{
	/**Constructor pt OperatorAtribuire;
	 * 
	 * @param cheie informatia - =;
	 * @param linie linia din fisier pe care se afla cheia;
	 * @param col coloana din fisier pe care se afla cheia;
	 */
	public OperatorAtribuire(String cheie, int linie, int col)
	{
		super(cheie, linie, col);
	}
	
	
	public void accept(Visitor v) 
	{
		v.visit(this);
	}

}