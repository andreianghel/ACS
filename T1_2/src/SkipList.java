import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SkipList
{
	
	
	
	public static void main(String[] args)
	{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try 
		{
			s = br.readLine();
		} catch (IOException e) 
		  {
			         System.out.println("Error!");
			         System.exit(1);
		  }
		
		/*StringTokenizer stNrParanteze = new StringTokenizer(s, ")");
		int nrParanteze = 0;
		while(stNrParanteze.hasMoreTokens()) nrParanteze++;
		System.out.println(nrParanteze);*/
		
		StringTokenizer st = new StringTokenizer(s, " ");
		int nrMiniExpresii = st.countTokens()/2;
		//creez si aloc spatiu pt nrMiniExpresii elemente;
		//si pt nrMiniExpresii striguri; va fi un String[] = new String[nrMiniExpresii]
	
		
		String[] saux = new String[nrMiniExpresii];
		//String saux2 = st.nextToken(")");
		int nr2 = nrMiniExpresii;
		//while(st.hasMoreTokens())
		//{
			/*saux[nrMiniExpresii-1] = st.nextToken(")");
			
		
		//System.out.println(saux2);
			String tot, expresia, restul;
			tot = reverse(saux[nrMiniExpresii-1]);
			System.out.println(tot);
			StringTokenizer st2 = new StringTokenizer(tot, "(");
			expresia = reverse(st2.nextToken());
			System.out.println(expresia);
			restul = reverse(st2.nextToken(""));
			restul = restul.substring(0, restul.length()-1);
			System.out.println(restul);
			nrMiniExpresii--;
		//}*/
			
			String expr, expresia, restStanga, restDreapta;
			expr = st.nextToken(")");
			expr = reverse(expr);
			StringTokenizer st2 = new StringTokenizer(expr, "(");
			expresia = reverse(st2.nextToken());
			restStanga = reverse(st2.nextToken(""));
			restStanga = restStanga.substring(0, restStanga.length()-1);
			restDreapta = st.nextToken("");
			restDreapta = restDreapta.substring(1, restDreapta.length());
			expresia = expresia.replaceAll(" ", "_");
			System.out.println(restStanga+"   "+expresia+"   "+restDreapta);
			
			
		
		/*while(nr2-1 >= 0)
		{
			//if(saux[nr2-1] == null) continue;
			System.out.println("saux["+(nr2-1)+"]="+saux[nr2-1]);
			nr2--;
			
		}*/
		//int x = 5/2+1;
		//System.out.println(nrMiniExpresii);
		
		
		//System.out.println(s);
		
	}
	

	public static String reverse(String s)
	{
	    return new StringBuffer(s).reverse().toString();
	}
	
	/*public static Element exprCalc(String expr)
	{
		Element a;
		a.cheie = expr.replaceALL(" ", "-");
		StringTokenizer st = new StringTokenizer(expr, " ");
		String s1, s2, s3;
		s1 = st.nextToken();
		s2 = st.nextToken();
		s3 = st.nextToken();
		
		if(s2.equals("OR"))
		{
			a.date = new Integer[this.OR(s1, s3).length];
			a.date = this.OR(s1, s3);
	
			return a;
		}
		else if(s2.equals("AND"))
		{
			a.date = new Integer[this.AND(s1, s3).length];
			a.date = this.AND(s1, s3);
	
			return a;
		}	
		else return null;
	}*/
	
}