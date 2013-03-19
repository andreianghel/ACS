public class Stiva extends Array
{
	//Array array;
	private int elem;
	
	public Stiva(){}
	
	public Stiva(int nrElem)
	{
		super(nrElem);
		elem = 0;
	}
	
	
	public void push(int nr)
	{
		super.set(elem, nr);
		elem++;
	}
	
	public int pop()
	{
		int i = 0;
		if(super.get(0) != super.ERROR)
		{
			i = super.get(elem - 1);
			super.set(elem, super.ERROR);
		}
		else 
			return super.ERROR;
		
		elem--;
		return i;
	}
	
	public int getL()
	{
		return elem;
	}
	
	

}
