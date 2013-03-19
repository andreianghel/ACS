import java.util.*;

public class Nod
{
	public Element e;
    public List<Nod> urm;

    

    public Nod(Element e)
    {
    	this.e = e;
    	this.urm = new ArrayList<Nod>();
    }

    public int level() 
    {
    	return this.urm.size()-1;
    }

    public String toString()
    {
    	return "Nod: " + this.e.cheie;
    }
}