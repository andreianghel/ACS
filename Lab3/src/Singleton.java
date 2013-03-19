public class Singleton 
{
	private int i;
	
	private Singleton(int i, int j)
	{	this.i = i;		}
		
	private Singleton(){}
	
	static private final Singleton s = new Singleton();
	
	public int get()
	{	return this.i;	}
	
	static public Singleton getObj()
	{	return s;	}
}
