/**
 * 
 * Clasa ce defineste tipul Nod
 * 
 * @author Andrei
 *
 */
public class Nod
{
	Nod[] urm;
	Element elem;
	
	public Nod(){}
	
	public Nod(int l, Element elem)	
	{
		this.urm = new Nod[l+1];
		this.elem = elem;
	}
}