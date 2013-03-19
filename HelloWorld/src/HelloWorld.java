
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		String s1, s2;
		s1 = "primul meu string";
		s2 = "al doilea";
		System.out.println(s1.length());
		System.out.println(s2.length());
		
	class DataOnly{
		int i;
		float f;
		boolean b;
		String s;
		}
	DataOnly d = new DataOnly();
	d.i = 1;
	System.out.println("ceva ceva integer " + d.i);

	public class VeterinaryReport {
	    int dogs;
	    int cats;

	    public int getAnimalsNo() {
	        return dogs + cats; // utilizare camp din acelasi obiect pentru care s-a facut apelul functiei
	    }

	    public void displayStatistics() {
	        System.out.println("Total number of animals is " + getAnimalsNo()); // apel metoda din aceeasi clasa
	   }
	}
	
	}
}
