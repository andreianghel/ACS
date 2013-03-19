import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 
 * Clasa Main
 * 
 * @author Andrei
 *
 */
public class Main 
{
	
	/**
	 * Metoda ce inverseaza caracterele unui string;
	 * 
	 * @param s: stringul ce va inversat;
	 * @return : stringul inversat;
	 */
	public static String reverse(String s)
	{
	    return new StringBuffer(s).reverse().toString();
	}

	
	/**
	 * 
	 * Metoda main
	 * 
	 * @param args : numele fisierului txt in care se afla dictionarul;
	 * 
	 */
	public static void main(String[] args)
	{
		Dictionary dict = new Dictionary(args[0]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try 
		{
			while((s = br.readLine()) != null)
		    {
				if(s.equals("exit")) break;
				
				if(!s.contains(")") || !s.contains("("))
				{
					if(dict.lista.search(s) == null)
						System.out.print("");
					else
					{
						System.out.print("");
						for(int i = 0; i < dict.lista.search(s).length; i++)
					    	  System.out.print(" "+dict.lista.search(s)[i]);
						System.out.println();
					}
				}
				else	//daca are ( ) in string
				{
					StringTokenizer st = new StringTokenizer(s, " ");
					int nrMiniExpresii = st.countTokens()/2;
					int contor = 0;
					
					while(contor < nrMiniExpresii)
					{	
						StringTokenizer st3 = new StringTokenizer(s, " ");
						String expr, expresia, restStanga, restDreapta;
						expr = st3.nextToken(")");
						expr = reverse(expr);
						StringTokenizer st2 = new StringTokenizer(expr, "(");
						expresia = reverse(st2.nextToken());
						restStanga = reverse(st2.nextToken(""));
						restStanga = restStanga.substring(0, restStanga.length()-1);
						restDreapta = st3.nextToken("");
						restDreapta = restDreapta.substring(1, restDreapta.length());
						
						//aici evaluarea si calcularea expresiei;
						Element aux51 = new Element();
						aux51 = dict.lista.exprCalc(expresia);
						
						dict.lista.insert(aux51, true);
						s = restStanga+aux51.cheie+restDreapta;
						
						contor++;
					}
					if(dict.lista.search(s) == null)
						System.out.println();
					else
					{
						for(int i = 0; i < dict.lista.search(s).length; i++)
						{
							if(dict.lista.search(s)[i]!= null)
								System.out.print(" "+dict.lista.search(s)[i]);
						}
					}
					System.out.println();
				}
			}
		} catch (IOException e) 
		  {
			         System.out.println("Error!");
			         System.exit(1);
		  }
	   
	}
}