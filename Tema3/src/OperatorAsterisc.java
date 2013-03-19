/**Clasa OperatorAsterisc;
 * 
 * @author ndr;
 */
public class OperatorAsterisc extends Node implements Visitable
{
	/**Constructor pt OperatorAsterisc;
	 * 
	 * @param cheie informatia - *;
	 * @param linie linia din fisier pe care se afla cheia;
	 * @param col coloana din fisier pe care se afla cheia;
	 */
	public OperatorAsterisc(String cheie, int linie, int col)
	{
		super(cheie, linie, col);
	}
	
	
	public void accept(Visitor v) 
	{
		v.visit(this);
	}

}