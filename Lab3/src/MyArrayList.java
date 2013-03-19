public class MyArrayList 
{
	private float[] vector;
	private int cont;
	
	public MyArrayList()
	{	this.vector = new float[10];
		this.cont = 0;	
	}	
	
	public MyArrayList(int i)
	{	this.vector = new float[i];	
		this.cont = 0;
	}
	
	public void add(float value)
	{
		int l = this.vector.length;
		if(l > this.cont)
			this.vector[this.cont] = value;
		else
		{
			this.vector = new float[2*l];
			this.vector[this.cont] = value;
		}
		cont++;
	}
	
	public boolean contains(float value)
	{
		for(int j = 0; j < cont; j++)
			if(this.vector[j] == value)
				return true;
		return false;
	}
	
	public void remove(int index)
	{
		if((index < 0) || (index > cont))
			System.out.println("Index negativ sau mai mare decat lungimea sirului");
		else 
		{
			for(int i = index; i < cont; i++)
			this.vector[i] = this.vector[i+1];
			cont--;
		}
	}
	
	public float get(int index)
	{	return this.vector[index];	}
	
	public int size()
	{	return this.cont;	}
	
	public String toString()
	{	
		String s = "";
		for(int i = 0; i < this.cont; i++)
		{
			s += this.vector[i];
			s += "|";
		}
	return s;
	}
}
