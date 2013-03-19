import java.util.*;

public class Student 
{
	String nume;
	float medie;
	
	public Student(String nume, float medie)
	{
		this.nume = nume;
		this.medie = medie;
	}
	
	public String toString()
	{
		return this.nume+": "+Float.toString(this.medie);
	}
	
	public boolean equals(Object o)
	{
		boolean rez = false;
		if(o instanceof Student)
		{
			Student s = (Student)o;
			if(this.nume.equals(s.nume))
				if(this.medie == s.medie)
					rez = true;
		}
		return rez;
	}
	
	public int hashCode()
	{
		return (int)(this.medie / 5) + 100001;
	}
	
	//----------ex3-----------
	public boolean equals(Student s)
	{
		return false;
	}
	
	public static void main(String[] args)
	{
		ex1 c = new ex1();
		
		c.c.add(new Student("A", 5f));
		c.c.add(new Student("B", 4f));
		c.c.add(new Student("A", 5f));
		c.c.add(new Student("B", 4f));
		c.c.add(new Student("A", 5f));
		c.c.add(new Student("B", 4f));
		
		System.out.println(c.c.size());	//print 2;
		
		/*for(Student s : c.c)
		{
			System.out.println(s.equals(s));
			System.out.println((Object)(s).equals((Object)(s)));
		}*/
		Iterator<Student> it = c.c.iterator();
		while(it.hasNext())
		{
			Student s = it.next();
			System.out.println(s.equals(s));
			System.out.println((Object)(s).equals((Object)(s)));
		}
	}
}
