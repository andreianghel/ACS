import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * Clasa ce defineste tipul dictionar
 * 
 * @author Andru
 *
 */
public class Dictionary 
{
	
	//private Element[] dictionar;	//vector de: cuvinte + index 
	private int numEntries = 0;	//nr de intrari din dictionar
	Nod head, tail;	//capul si coada listei raman constante si se vor regasi pe toate nivelurile;
	double prob = 0.5; //arunci o moneda: iese cap, "promovezi" celula la lista de nivel superior; if(cap) -> mai arunci o data;
	Random rand;
	
	/**
	 * 
	 * Constructor pentru dictionar. Primeste ca parametru numele fisierului text (dictionarului) si il citeste linie cu linie
	 * 
	 * @param inputFile
	 * Numele fisierului text
	 */
	public Dictionary(String inputFile) 
	{
		try
		{
			File dictFile = new File(inputFile);
			Scanner reader = new Scanner(dictFile);
			String strLine;
			
			BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
			int linii = 0;
			while (reader2.readLine() != null) linii++;
			reader2.close();
			//metoda pentru a numara liniile (astfel cheile) din fisier
			
			while (reader.hasNextLine())
			{
				strLine = reader.nextLine(); // in strLine este linia curenta din dictionar
				System.out.println(strLine);
				
				// TO DO: aici veti procesa fiecare linie din dictionar
				// HINT: String tokenizer
				StringTokenizer st = new StringTokenizer(strLine, " ");
				int i = -1;
				boolean k = true;
				while(st.hasMoreTokens()) 
				{
					if(k) //k e true pt primul ciclu-> primul cuv este cheia, restul vor fi retinute ca int intr-un vector
					{
						dictionar[numEntries].cheie = st.nextToken();
						k = false;
					}
					else
						dictionar[numEntries].nr[i++] = Integer.parseInt(st.nextToken());
				}
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
	 * @return
	 * Numarul de intrari din dictionar
	 */
	public int getnumEntries() {
		return numEntries;
	}
}
