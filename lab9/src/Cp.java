import java.io.*;

class Cp
{
//l-am optimizat cu BufferedReader, de la FileInputStream, acum copiaza linie cu linie, fata de caracter-caracter;
	public static void main(String[] args)	
	{
		String line = null;
		BufferedReader in = null;
		BufferedWriter out = null;

		try 
		{
			in = new BufferedReader(new FileReader(args[0]));
			out = new BufferedWriter(new FileWriter(args[1]));
			
			while ((line = in.readLine()) != null)
				out.write(line+"\n");
			in.close();
			out.close();
		} catch(Exception e) {
				System.out.println("Err: "+e.getMessage());
		}
	}
}	

