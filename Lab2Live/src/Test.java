public class Test 
{
	private static int i1;
	private int i2;
	
	public Test(int i1, int i2)
	{
		this.i1 = i1;
		this.i2 = i2;
	}
	
	public void afisare()
	{
		System.out.println("ceva, ceva: "+this.i1+", "+this.i2);
	}
	
	
	
	
	public static void main(String[] args) 
	{
		long startTime = System.nanoTime();
		int i = 2+3;
		long endTime = System.nanoTime();
		System.out.println("2+3: "+(endTime - startTime)+" nanosec"); 	
		
		startTime = System.nanoTime();
		new Integer(2+3);
		endTime = System.nanoTime();
		System.out.println("new Integer(2+3): "+(endTime - startTime)+" nanosec"); 
		
		
			String[] s1 = new String[1000000];
			
			/*for(i = 0; i < s1.length; i++)
			{
				s1[i] = "abc";
			}*/
			
			String[] s2 = new String[1000000];
			for(int j = 0; j < s2.length; j++)
			{
				s2[j] = new String("abc");
			}
			
		    long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		    System.out.println("Mem used: "+usedMem);
		    
		    
		    PasswordMaker p = new PasswordMaker("Anghel", "Andrei", 20);
		    //String s = PasswordMaker.getPassword();
		    System.out.println("Parola generata: "+p.getPassword());
		    float[] x = {1, 2, 3, 4, 5, 6};
		    Poligon p1 = new Poligon(x);
		    
		    Test obiect = new Test(1, 2);
		    Test obiect2 = new Test(3, 4);
		    obiect.afisare();
		    obiect2.afisare();
		    
		    
		    
		   
		    
		    
		    
	}
}
