public class Poligon
{
	private Punct[] p;
	private int i;
	
	public Poligon(int i)
	{
		p = new Punct[i];
	}
	
	public Poligon(float[] v)
	{
		this(3);
		int k = 0;
		for(i = 0; i < 6; i += 2)
		{
			p[k] = new Punct(v[i], v[i+1]);
			k++;
		}
		
		for(i = 0; i < 3; i++)
		{
			p[i].afis();
		}
	}
}
