import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clasa ce defineste tipul Nod
 * 
 * @author Andrei
 *
 */
public class Nod
{
	List<Nod> urm;
	Element elem;
	
	public Nod(){}
	
	public Nod(int l, Element elem)	//construieste un nod si ii aloca spatiu pentru l+1 niveluri;
	{
		this.urm = new ArrayList<Nod>(l+1);
		this.elem = elem;
	}
}