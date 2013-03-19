import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * Clasa ce defineste tipul dictionar
 * 
 * @author Andrei
 *
 */
public class Dictionary 
{
	
	private int numEntries = 0;	//nr de intrari din dictionar
	public Element aux2;
	public SkipList2 lista;
	
		
	/**
	 * 
	 * Constructor pentru dictionar. Primeste ca parametru numele fisierului text (dictionarului) si il citeste linie cu linie
	 * 
	 * @param inputFile: Numele fisierului text
	 */
	public Dictionary(String inputFile) 
	{
		
		lista = new SkipList2();
		try
		{
			File dictFile = new File(inputFile);
			Scanner reader = new Scanner(dictFile);
			String strLine = new String();

			while (reader.hasNextLine())
			{
				strLine = reader.nextLine(); 
				
				StringTokenizer st = new StringTokenizer(strLine, " ");
				int i = 0;
				
				aux2 = new Element();	//mica alocare;
				aux2.cheie = st.nextToken();
				aux2.date = new Integer[st.countTokens()];
				while(st.hasMoreTokens()) 
				{
						aux2.date[i] = Integer.parseInt(st.nextToken());
						i++;
				}
				lista.insert(aux2, false);
				numEntries++;
			}
			reader.close();
		}
		catch (Exception e) 
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * Metoda ce returneaza numarul de intrari din dictionar
	 * 
	 * @return Numarul de intrari din dictionar
	 */
	public int getnumEntries() 
	{
		return numEntries;
	}
	
	/**
	 * Metoda ce numara liniile dintr-un fisier;
	 * 
	 * @param filename : numele fisierului txt;
	 * @return : nr de linii;
	 * @throws IOException
	 */
	

}