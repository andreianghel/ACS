import java.util.*;

public class ex1 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		Random rand = new Random();
		List myIntList = new LinkedList();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++)
			myIntList.add(new Integer(rand.nextInt())); 
		for(int i = 0; i < 100000; i++)
			myIntList.get(rand.nextInt(100000));
		long end = System.currentTimeMillis();
		System.out.print("Time1: ");
		System.out.print(end-start);
		
		long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	    System.out.println("\t\nMem used: "+usedMem);
		
		
		List<Integer> myIntList1 = new LinkedList<Integer>(); 
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++)
			myIntList1.add(new Integer(rand.nextInt())); 
		for(int i = 0; i < 100000; i++)
			myIntList1.get(rand.nextInt(100000));
		end = System.currentTimeMillis();
		System.out.print("\nTime2: ");
		System.out.print(end-start);
		long usedMem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	    System.out.println("\t\nMem used: "+(usedMem1-usedMem));
	}
}
