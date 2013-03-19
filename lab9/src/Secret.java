import java.io.*;

public class Secret 
{
	public static void main(String[] args)
	{
		try
		{
			DataInputStream in = new DataInputStream(new FileInputStream("secret.txt"));
			System.out.println(in.skip(in.readLong()));
		} catch(Exception e)
		{	System.out.println("Err: "+e.getMessage());		}
	}
}
