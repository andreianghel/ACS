import java.util.Vector;


public class Test 
{
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
		
		/*1p) Testati diferenta de memorie utilizata intre a folosi String literal si String obtinut prin constructor. 
		 * Construiti un vector de String. Umpleti acest vector in prima faza cu literal-ul "abc" si masurati memoria 
		 * utilizata. Apoi, umpleti vectorul cu new String("abc") si masurati memoria utilizata. Masurarea memoriei 
		 * utilizate se poate face folosind urmatoarea metoda:
public void showUsedMemory() {
    long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.println(usedMem);
}*/
			//Vector<String> vectorString;
			//String[] vectorString = {"abc", "abc", "abc"};
			//String[] vectorString = new String("abc");
			
			
		    long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		    System.out.println(usedMem);
	}
}
