import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	public Element[] aux2;
	public SkipList2 lista;
	public int[] i2;
	
		
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
			
		    int linii = 0;
			BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
			while (reader2.readLine() != null) linii++;
			reader2.close();
			/*LineNumberReader  linii = new LineNumberReader(new FileReader(new File(inputFile)));
			linii.skip(Long.MAX_VALUE);*/
			
			aux2 = new Element[linii];
			
			while (reader.hasNextLine())
			{
				strLine = reader.nextLine(); 
				
				StringTokenizer st = new StringTokenizer(strLine, " ");
				int i = 0;
				
				aux2[numEntries] = new Element();
				aux2[numEntries].cheie = st.nextToken();
				aux2[numEntries].date = new Integer[st.countTokens()];
				while(st.hasMoreTokens()) 
				{
						aux2[numEntries].date[i] = Integer.parseInt(st.nextToken());
						i++;
				}
				numEntries++;
			}
			reader.close();
		}
		catch (Exception e) 
		{
			System.err.println("Error: " + e.getMessage());
		}
		
		for(int i7 = 0; i7 < numEntries; i7++)
		{
			lista.insert(aux2[i7], false);
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
		return lista.contor;
	}
}
