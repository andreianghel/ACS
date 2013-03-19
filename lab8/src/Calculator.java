import java.util.Collection;
import java.util.Iterator;

public class Calculator 
{
	public Integer add1(Integer a, Integer b) throws Exception
	{
			if(a+b < Integer.MIN_VALUE)
				throw new UnderflowException();
			if(a+b > Integer.MAX_VALUE)
				throw new OverflowException();
			return a+b;
	}
	public Integer add(Integer a, Integer b) throws Exception
	{	
		try{
			return add1(a, b);
		} catch(UnderflowException e)
		{
			System.out.println("UFE: "+e);
			return add1(a, b);
		} catch(OverflowException e)
		{
			System.out.println("OFE: "+e);
			return add1(a, b);
		}
	}
	
	public Integer divide1(Integer a, Integer b) throws Exception
	{
		if(b == 0)
			throw new Exception();
		return (Integer)(a/b);
	}
	public Integer divide(Integer a, Integer b) 
	{
		try{
			return divide(a, b);
		} catch(Exception e)
		{
			System.out.println("Err: "+e);
			return null;
		}
		
	}
	
	public Integer average(Collection<Integer> c) throws Exception
	{
		Integer suma = 0;
		
		Iterator<Integer> it = c.iterator();
		while(it.hasNext())
		{	
			if(!it.hasNext()) throw new Exception();
			suma = add(suma, it.next());
		}
		return (Integer)(divide(suma, c.size()));
	}
	
	public class OverflowException extends Exception{}
	public class UnderflowException extends Exception{}
	

}
