import java.util.Random;

public class SL
{
	public class Nod
	{
		public Element e;
		public int level;
		public Nod next;
		public Nod down;
		
		public Nod(Element e, int level, Nod next, Nod down)
		{
			this.e = e;
			this.level = level;
			this.next = next;
			this.down = down;
		}
	}
	
	public Nod head;
	public Random rand;
	public long  numEntries;
	
	
	public int getLevel()
	{
		int l = 0;
   	    while(rand.nextFloat() <= 0.5 && l < (int)(Math.log(this.numEntries)/Math.log(2))) l++;
   	    
   	    return l;
	}
		
			
	public SL(int numEntries)
	{
		this.head = new Nod(null, 0, null, null);
		rand = new Random();
		this.numEntries = numEntries;
		
	}
	
	public void insert(Element e)
	{
		int l = this.getLevel();
		if (l > this.head.level)
		{
			this.head = new Nod(null, l, null, this.head);
		}
		
		Nod x = this.head;
		Nod last = null;
		
		while (x != null) {
			if (x.next == null || x.next.e.cheie.compareTo(e.cheie) > 0)
			{
				if (l >= x.level) 
				{
					Nod n = new Nod(e, x.level, x.next, null);
					if (last != null) {
						last.down = n;
					}
					
					x.next = n;
					last = n;
				}
				
				x = x.down;
				continue;
			} 
			/*else if (x.next.e.cheie.equals(e.cheie))
			  {
				x.next.value = value;
				return;
			  }*/
			
			x = x.next;
		}
	}
	
	/*public boolean containsKey(T key)
	{
		return get(key) != null;
	}
	
	public U remove(T key)
	{
		U value = null;
		
		Node cur = _head;
		while (cur != null) {
			if (cur.next == null || cur.next.key.compareTo(key) >= 0) {
				if (cur.next != null && cur.next.key.equals(key)) {
					value = cur.next.value;
					cur.next = cur.next.next;
				}
				
				cur = cur.down;
				continue;
			}
			
			cur = cur.next;
		}
		
		_size--;
		return value;
	}
	
	public U get(T key)
	{
		Node cur = _head;
		while (cur != null) {
			if (cur.next == null || cur.next.key.compareTo(key) > 0) {
				cur = cur.down;
				continue;
			} else if (cur.next.key.equals(key)) {
				return cur.next.value;
			}
			
			cur = cur.next;
		}
		
		return null;
	}*/
}