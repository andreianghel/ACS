import java.util.Random;

public class SL
{

	  public Nod head;
	  public int maxLevel;
	  public int numEntries;
	  public int size;
	  Random rand = new Random();
	  
	  public SL(int numEntries)
	  {
		  this.numEntries = numEntries;
		  maxLevel = (int)(Math.log(numEntries)/Math.log(2));
		  head = new Nod(null);
		  size = 0;
	  }
	  
	  public boolean add(Element e)
	  {
		  size++;
		  // random number from 0 to maxLevel+1 (inclusive)
		  int l = 0;
      	  while(rand.nextFloat() <= 0.5 && l < this.maxLevel) l++;
		  
      		
		  Nod newNode = new Nod(e);
		  Nod current = head;
		  while(l > 0)
		  {
			  current = findNext(e, current, l);
		 	newNode.urm.add(0, current.urm[l]);
		 	current.urm.set(l, newNode);
		 	l--;
		  } 
	  }
	  
	  
	
	
	
	
	
	
	
}