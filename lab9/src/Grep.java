import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Grep 
{
	public static void main(String[] args)
	{
		try
		{
			File file = new File(args[0]);
			Scanner reader = new Scanner(file);
			String strLine = new String();
			int line = 0;

			while (reader.hasNextLine())
			{
				strLine = reader.nextLine(); 
				StringTokenizer st = new StringTokenizer(strLine, " ");
				line++;
				while(st.hasMoreTokens())
					if(st.nextToken().equals(args[1]))
						System.out.println("Linia: "+line+"\n\t:\""+strLine+"\"");
			}
		} catch(Exception e)
		{
			System.out.println("Err: "+e.getMessage());
		}
	}
}
