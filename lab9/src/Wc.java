import java.io.*;
import java.util.*;

public class Wc
{
	public static void main(String[] args)
	{
		try
		{
			if(args[0].equals("-l"))
			{
				BufferedReader reader = new BufferedReader(new FileReader(args[1]));
				int lines = 0;
				while (reader.readLine() != null) lines++;
				reader.close();
				
				System.out.println(lines);
			}
			else if(!args[0].equals("-l"))
			{
				File dictFile = new File(args[0]);
				Scanner reader = new Scanner(dictFile);
				String strLine = new String();
				int words = 0;

				while (reader.hasNextLine())
				{
					strLine = reader.nextLine(); 
					StringTokenizer st = new StringTokenizer(strLine, " ");
					words += st.countTokens();
				}
				System.out.println(words);
			}
		} catch(Exception e) {
			System.out.println("Err-in: "+e.getMessage());
			return;
		}
	}
}