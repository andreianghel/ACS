import java.util.*;

public class ex1 
{
	/*Collection<String> c = new HashSet<String>();
	
	public void add(String s)
	{
		if(c.contains(s))
			System.out.println("Ceva");	//mesaj corescunzator, ca elementul exista in colectie;
		else 
			System.out.println(c.add(s));	//true daca, colectia s-a modificat;
	}*/
	
	Collection<Student> c = new HashSet<Student>();
	public void add(Student s)
	{
		if(c.contains(s))
			System.out.println("Ceva");	//mesaj corescunzator, ca elementul exista in colectie;
		else 
			System.out.println(c.add(s));	//true daca, colectia s-a modificat;
	}
	
	
	/*public static void main(String[] args)
	{
		ex1 c = new ex1();
		
		c.add("abc");
		c.add("bcd");
		c.add("bcd");
		c.add("abc");
		c.add("bcd");
		c.add("bcd");
		
		System.out.println(c.c.size());
	}*/

}
