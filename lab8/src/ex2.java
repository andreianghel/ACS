import java.util.ArrayList;

public class ex2 
{
	static class ceva
	{
		int a, b, c, d, e, f, g, h, i, j;
		float a1, b1, c1, d1, e1, f1, g1, h1, i1, j1;
		String a2, b2, c2, d2, e2, f2, g2, h2, j2;
		double a3, b3, c3, d3, e3, f3, g3, h3, j3, k3, l3;
		double[] a4, b4, c4, d4, e4, f4, g4, h4, j4, k4;
	}
	
	public static void met1()
	{
		ArrayList<ceva> lista = new ArrayList<ceva>();
		
			while(true)
			{	lista.add(new ceva());  	}
	}
	
	public static void met2()
	{	met2();	  }
	
	public static void main(String[] args)
	{
		try{
			met1();
		} catch(Throwable e)
		{
			System.out.println("Exception: "+e);
		}
		
	}
}
