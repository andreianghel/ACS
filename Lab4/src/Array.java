import java.util.Random;

public class Array 
{
	public static final int ERROR = Integer.MIN_VALUE;
	
	// vectorul din spate
	private int a[];
	
	public Array() {
		this(10);
	}
	
	public Array(int n) {
		a = new int[n];
	}
	
	public int get(int pos) {
		// verificare pozitie valida
		if (pos < 0 || pos >= a.length)
			return ERROR;
		
		return a[pos];
	}
	
	public int set(int pos, int val) {
		// verificare pozitie valida
		if (pos < 0 || pos >= a.length)
			return ERROR;
		
		a[pos] = val;
		
		return 0;
	}
	
	public String toString() {
		String s = "[";
		for (int i = 0; i < a.length; i++)
		{
			if(a[i] == ERROR) continue;
			s += a[i] + " ";
		}
		return s + "]";
	}

	public static void main(String[] args) {
		// array cu 10 elemente
		Array array = new Array(10);
		
		//*********** EXEMPLE DE ADAUGARE ******************
		
		//adaugare corecta
		array.set(0, 50);
		if ( array.set(4, 99) != Array.ERROR) 
			System.out.println(array);
		else
			System.out.println("Error adding value");
		
		//adaugare incorecta
		if ( array.set(11, 99) != Array.ERROR) 
			System.out.println(array);
		else
			System.out.println("Error adding value");
		
		//*********** EXEMPLE DE OBTINERE ******************
		
		//obtinere corecta
		int val = array.get(4);
		if ( val != Array.ERROR) 
			System.out.println(val);
		else
			System.out.println("Error retrieving value");
		
		//obtinere incorecta
		val = array.get(11);
		if ( val != Array.ERROR) 
			System.out.println(val);
		else
			System.out.println("Error retrieving value");
		
		Stiva s=new Stiva(5);
		
		for(int i=0; i<5; i++){
			Random g = new Random();
			int e=g.nextInt(10);
			System.out.println(e);
			s.push(e);
			System.out.println("Stiva mostenire: "+s);
		}
		
		System.out.println("Nr de elem initial: "+s.getL());
		System.out.println("Elementul scos: "+s.pop());
		//System.out.println("Stiva dupa elim "+s);
		System.out.println("Nr elem fin: "+s.getL());
		
		Stiva s1=new Stiva(5);
		
		for(int i=0; i<5; i++){
			Random g = new Random();
			int e=g.nextInt(10);
			System.out.println(e);
			s1.push(e);
			System.out.println("Stiva agregare: "+s1);
		}
		System.out.println("Nr de elem initial: "+s1.getL());
		System.out.println("Elementul eliminat: "+s1.pop());
		System.out.println("Nr elem fin: "+s1.getL());
		//System.out.println("Stiva agregare: "+s1);
		s1.pop();
		System.out.println("Stiva agregare: "+s1);
	
		
	}

}