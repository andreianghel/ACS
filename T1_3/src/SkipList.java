import java.util.Random;

public class SkipList
{
	public int nivel = 0;
	public Nod head = new Nod(nivel, null); 
	Random rand;
	
	
	public void insert(SkipList lista, Element elem, int linii)
	{
		int l = 0;
		while(rand.nextFloat() <= 0.5 && l < (int)(Math.log(linii)/Math.log(2))) l++;
		
		if(l > lista.nivel)
    	{
    		for (int i = lista.nivel + 1; i <= l; i++) 
    		{
 	            head.urm.add(null);	//completez head cu null pe noile niveluri;
 	        }
 	        lista.nivel = l;
 	    }
		
		Nod nod = new Nod(l, elem);
		Nod aux = head;
		for(int i = 0; i < nivel; i++)
		{
			nod.urm.add(0, aux.urm.get(nivel));
			nod.urm.set(nivel, nod);
		} 
	}
	
	/*public Nod search(Element elem) 
	{
        Nod next = (Nod)head.urm.get(nivel);
        while(next != null) 
        {
        	//Element aux = next.elem.cheie;
        	
        	if(next.elem.cheie.compareTo(elem.cheie) < 0)
        		break;
        	head = next;
        	next = head.urm.get(nivel);
        }
        return head;
    }*/

	

}
