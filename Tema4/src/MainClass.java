import java.util.ArrayList;
import java.util.Random;

public class MainClass
{
	/**Metoda ce genereaza un nume de lungime maxim 15;
	 * 
	 * @return numele studentului;
	 */
	public static String genNume()
	{
		Random rand = new Random();
		
		char[] nume = new char[15];
		for(int j = 0; j < rand.nextInt(15); j++)		
			nume[j] = "abcdefghijklmnopqrstuvwxyz".charAt(rand.nextInt(25));
		
		return new String(nume);
	}
	
	/**Main;
	 * 
	 * @param args paramterii in linie de comanda;
	 */
	public static void main(String[] args)
	{
		Random rand = new Random();
		ArrayList<Student> list = new ArrayList<Student>();
		ArrayList<LazyStudent> list2 = new ArrayList<LazyStudent>();
		MyHashMapImpl<Student, Integer> hash = new MyHashMapImpl<Student, Integer>(25); 
		MyHashMapImpl<LazyStudent, Integer> hash2 = new MyHashMapImpl<LazyStudent, Integer>(25);
		
		for(int i = 0; i < 1001; i++)	//generare studenti, ciudati si normali;
		{
			list.add(new Student(genNume(), Math.abs(rand.nextInt(25 - 18 + 1) + 18))); //varsta va fi intre 18 si 25 ani
			list2.add(new LazyStudent(genNume(), Math.abs(rand.nextInt(25 - 18 + 1) + 18)));
			
			for(Student s : list)
				hash.put(s, Math.abs(rand.nextInt(10)));
			
			for(LazyStudent ls : list2)
				hash2.put(ls, Math.abs(rand.nextInt(10)));
		}
		
		//testing
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1001; i++)
			hash.get(list.get(Math.abs(rand.nextInt(1001))));
		long end = System.currentTimeMillis();
		System.out.print("1001-get: Pt Student: ");
		System.out.print(end - start);
		
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 1001; i++)
			hash2.get(list2.get(Math.abs(rand.nextInt(1001))));
		end = System.currentTimeMillis();
		System.out.print("\n1001-get: Pt LazyStudent: ");
		System.out.print(end - start);
	}
}
