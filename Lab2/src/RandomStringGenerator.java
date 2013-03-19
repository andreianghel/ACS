import java.util.Random;


public class RandomStringGenerator 
{
	Integer lungimeSir;
	String alfabet;

	public RandomStringGenerator(int lungimeSir, String alfabet)
	{
		this.lungimeSir = lungimeSir;
		this.alfabet = alfabet;
	}
	
	
	public String next()
	{
		char[] a = this.alfabet.toCharArray();
		char[] b = new char[this.lungimeSir];
		int j;
		Random generator = new Random();
		for(int i = 0; i < this.alfabet.length(); i++)
		{	
			j = generator.nextInt(this.lungimeSir);
			b[i] = a[j];
		}
		
		String result = new String(b);
		return result;
	}
	
}
