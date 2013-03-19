import java.io.*;

public class Ls
{
	public static void ls(File file)
	{
		try
		{
			if(file.isFile())
				System.out.println("Nume: "+file.getName()+", dimensiune: "+file.length());
			if(file.isDirectory())
				for(File auxFile : file.listFiles())
					ls(auxFile);
		} catch(Exception e)
		{	System.out.println("Err: "+e.getMessage());}
	}
	
	public static void main(String[] args)
	{
			ls(new File(args[0]));
	}
}
