import java.util.*;

public class ex5 extends LinkedList<Integer>	//Nici o diferenta daca schimb HashSet cu LinkedList ->>>>genericitate
{
	int nrElemAdd = 0;
	
	public boolean add(Integer i)
	{
		/*if(super.contains(i)) 	<-mai trebuia verificat pt duplicate?
			return false;
		else
		{*/
			super.add(i);
			nrElemAdd++;
			return true;
		//}	
	}
	
	public boolean addAll(LinkedList<Integer> c)
	{
		boolean rez = false;
		for(Integer i : c)
		{
			this.add(i);
			rez = true;
		}
		return rez;
	}
	
	public static void main(String[] args)
	{
		ex5 c = new ex5();
		System.out.println("before: "+c.nrElemAdd);
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(8);
		c.add(5);
		System.out.println("After: "+c.nrElemAdd);
		
		ex5 c1 = new ex5();
		c1.add(8);
		c1.add(6);
		System.out.println("before: "+c1.nrElemAdd);
		c1.addAll(c);
		System.out.println("After: "+c1.nrElemAdd);
		
	}
}
