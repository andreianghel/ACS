public class Stiva1 
{
	private Array a;
	private int elem;
	
    public Stiva1(){}
	
	public Stiva1(int nrElem)
	{
		a = new Array(nrElem);
		elem = 0;
	}
	
	
	public void push(int nr)
	{
		a.set(elem, nr);
		elem++;
	}
	
	public int pop()
	{
		int i = 0;
		if(a.get(0) != a.ERROR)
		{
			i = a.get(elem - 1);
			a.set(elem, a.ERROR);
		}
		else 
			return a.ERROR;
		
		elem--;
		return i;
	}
	
	public int getL()
	{
		return elem;
	}
	
	

}
