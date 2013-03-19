import java.util.Random;

public class Test 
{
	
	public static void main(String[] args)
	{
	
	MyArrayList a = new MyArrayList(5);
	MyArrayList b = new MyArrayList();
	
	
	/*float x = 5;
	a.add(5);
	a.add(3);
	a.add(-2);
	a.add(4);*/
	for(int i = 0, j = 0; i < 3; i++, j++)
	{
		a.add(i);
		System.out.println("a["+i+"] = "+a.get(j));
		
	}
	
	System.out.println("size a[]: "+a.size());
	
	Random generator = new Random();
	float value;
	for(int i = 0; i < 10; i++)
	{
		value = generator.nextFloat();
		b.add(value);
		//System.out.println("b["+i+"] = "+value);
	}
	System.out.println("b.Sub forma de string: "+b.toString());
	
	for(int i = 0; i < 5; i++)
	{
		value = generator.nextFloat();
		System.out.println("The list contains "+value+": "+b.contains(value));
	}
	//System.out.println("Sub forma de string: "+b.toString());
	
	int value2;
	for(int i = 0; i < 5; i++)
	{
		value2 = generator.nextInt();
		b.remove(value2);
	}
	
	
	
	}
}
