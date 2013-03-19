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