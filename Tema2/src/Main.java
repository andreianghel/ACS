import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Main 
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		LineNumberReader lnr = null;
		String inputFile, strLine, j;
		
		try
		{
			lnr = new LineNumberReader(new FileReader(new File("in.txt")));
		
			for(int i = 0; i < 2; i++)
				if(lnr.readLine() != null)	System.out.println("hihi");;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				lnr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
