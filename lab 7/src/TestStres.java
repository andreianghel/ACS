import java.util.*;

public class TestStres
{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		Random rand = new Random();
		
		//pt ArrayList
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++)
		{
			a.add(rand.nextInt());
		}
		for(int i = 0; i < 10000; i++)
		{
			a.add(rand.nextInt(10000), rand.nextInt());
			a.remove(rand.nextInt(10000));
		} 
		long end = System.currentTimeMillis();
		System.out.println("Pt ArrayList: ");
		System.out.print(end-start);
		
		//pt LinkedList
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++)
		{
			l.add(rand.nextInt());
		}
		for(int i = 0; i < 10000; i++)
		{
			l.add(rand.nextInt(10000), rand.nextInt());
			l.remove(rand.nextInt(10000));
		}
		end = System.currentTimeMillis();
		System.out.println("\nPt LinkedList: ");
		System.out.print(end-start);
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++)
		{
			a.get(rand.nextInt(100000));
		}
		end = System.currentTimeMillis();
		System.out.println("\nGet ArrayList: ");
		System.out.print(end-start);
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++)
		{
			l.get(rand.nextInt(100000));
		}
		end = System.currentTimeMillis();
		System.out.println("\nGet LinkedList: ");
		System.out.print(end-start);
		
		//get la LinkedList e f mare!
	}

	
	
}
