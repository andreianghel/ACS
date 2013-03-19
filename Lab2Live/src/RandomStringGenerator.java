import java.util.Random;


public class RandomStringGenerator
{
	private int lungimeSir;
	private String alfabet;
	
	public RandomStringGenerator(int lungimeSir, String alfabet)
	{
		this.lungimeSir = lungimeSir;
		this.alfabet = alfabet;
	}
	
	public String next()
	{
		char[] a = this.alfabet.toCharArray();
		char[] b = new char[this.lungimeSir];
		Random generator = new Random();
		for(int i = 0, value; i < this.lungimeSir; i++)
		{
			value = generator.nextInt(this.lungimeSir);
			b[i] = a[value];
		}
		
		String result = new String(b);
		return result;
	}
}
