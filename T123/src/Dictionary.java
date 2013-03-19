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
	
	private int numEntries = 0;	//nr de intrari din dictionar
	public Element aux2 = new Element();
	public int lines;
	Random rand = new Random();
	public final Nod head = new Nod(lines, null);	//head nu se modifica, cheie null, pt a nu conta la cautare;
	
	int level = 0;
	
	/**
	 * functie ce insereaza un elem in lista
	 * 
	 * @param elem - elementul de inserat
	 * @param lines - nivelul maxim ce se poate crea
	 * 
	 */
	
	public void insert(Element elem)
	{
		Nod nod = head; 
		Nod[] aux = new Nod[this.lines+1]; /*aux = vector de "pointeri din stanga"
								aux <- ultimul nod atins(existent) pe nivelul respectiv(se repeta pe toate nivelurile;*/
		
		
		for (int i = level; i >= 0; i--) 
        {
			while (nod.urm[i] != null) /*elementele sunt sortate deja, se insereaza in ordine corecta, 
										*verific doar daca am ajuns la final, null*/
       	 		nod = nod.urm[i];
       	 	aux[i] = nod; //retin adresa
        }
        nod = nod.urm[0]; //am revenit pe nivelul 0 unde se face inserarea
        
       if(nod == null || !nod.elem.cheie.equals(elem.cheie))
        //	nod.elem = elem;	//daca cheia exista, ii actualizez valoarea;
        
        {	/*generez un nivel aleator; daca este mai mare ca nivelul listei -> actualizez nivelul listei si 
        	 *	retin in aux "pointerii din stanga" dintre nivelurile level+1 si l*/
        	
    	    int l = 0;
       	    while(rand.nextFloat() <= 0.5 && l < (int)(Math.log(this.lines)/Math.log(2))) l++;
        	
        	if(l > level)
        	{
        		for (int i = level + 1; i <= l; i++) {
     	            aux[i] = head;
     	        }
     	        level = l;
     	    }
        	
        	/*alocam spatiu pt noul nod si ii atribuim "pointerii din dreapta" pe care ii are aux*/
        	nod = new Nod(l, elem);
        	for(int i = 0; i <= l; i++)
        	{	
        		nod.urm[i] = aux[i].urm[i];
        		aux[i].urm[i] = nod; //testeaza daca merge fara linia asta!
        	}
        		
        }
	}
	
	public String toString()
	{
	         StringBuilder sb = new StringBuilder();
	         sb.append("{");
	         Nod nod = head.urm[0];
	         while (nod != null) 
	         {
	             sb.append(nod.elem.cheie);
	             nod = nod.urm[0];
	             if(nod != null)
	                 sb.append(",");
	         }    
	         sb.append("}");
	         return sb.toString();
	}
	
	/*public void numara(Dictionary d)
	{
		while(d. != null)
		
	}*/
		
	
	
	
	
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
			String strLine = new String();
			
			BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
			while (reader2.readLine() != null) numEntries++;
			reader2.close();
			//numar linii (astfel cheile) din fisier; am nevoie de linii pt a eficientiza distributia pe niveluri;
			//aux2.cheie = "";
			//aux2.date = new int[100];
			
			this.lines = numEntries; //necesar pt a determina nivelul maxim ce se poate crea;
			aux2 = new Element();
			while (reader.hasNextLine())
			{
				strLine = reader.nextLine(); // in strLine este linia curenta din dictionar
				StringTokenizer st = new StringTokenizer(strLine, " ");
				int i = 0;
				aux2.cheie = st.nextToken();
				System.out.println("aux2.cheie: "+aux2.cheie);
				
				while(st.hasMoreTokens()) 
				{
						//System.out.println("t: "+st.nextToken());
						aux2.date[i] = st.nextToken().charAt(0);
						System.out.print("|"+aux2.date[i]+"|");
						i++;
				}
				System.out.println();
				
				System.out.println("inainte de inserare");
				this.insert(aux2);
				//System.out.println("ceva: "+lista.search(aux2)[0]);
				System.out.println("dupa inserare: ");
				System.out.println("din dict: "+this.toString());
				
				
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
