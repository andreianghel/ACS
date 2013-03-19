import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Cript //criptare+decriptare normala fara a aplica decorator
{
	public static void cript(String s1, String s2)
	{
		int i = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try 
		{
				in = new FileInputStream(s1);
				out = new FileOutputStream(s2);
				
				do
				{
					if((i = in.read()) != -1) 
					{
						System.out.print((char)(i));
						out.write(i+5);
					}
				} while(i != -1);
				in.close();
				out.close();
		} catch (Exception e){
			System.out.println("Err: "+e.getMessage());
		}	
	}
	
	public static void decript(String s1, String s2)
	{
		int i = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try 
		{
				in = new FileInputStream(s1);
				out = new FileOutputStream(s2);
				
				do
				{
					if((i = in.read()) != -1) 
					{
						System.out.print((char)(i));
						out.write(i-5);
					}
				} while(i != -1);
				in.close();
				out.close();
		} catch (Exception e){
			System.out.println("Err: "+e.getMessage());
		}	
	}
	
	public static void main(String args[])
	{
		cript(args[0], args[1]);
		decript(args[1], "_"+args[1]);
	}
}