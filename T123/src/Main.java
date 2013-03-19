/**
 * 
 * Clasa Main
 * 
 * @author Andru
 *
 */
public class Main {
	
	/**
	 * 
	 * Metoda main
	 * 
	 * @param args
	 * Argumentele primite de program
	 */
	public static void main(String[] args)
	{
		Dictionary dict = new Dictionary(args[0]);
		System.out.println("Avem " + dict.getnumEntries() + " intrari in dictionar");	
		//SkipSet lista = new SkipSet();
		Element a = new Element();
		Element b = new Element();
		Element c = new Element();
		Element d = new Element();
		//a.cheie = "Andre";
		
		//System.out.println("din main: "+dict.lista.toString());
		//String s = new String(dict.lista.search(a));
		//System.out.println("search: "+dict.lista.search(a)+"");
	/*	
			for(char k = 'a'; k < 'z'; k++)
				a.cheie += k+"";
			for(int i = 0; i < 5; i++)
				a.date[i] = (char)i;
			
			for(char k = 'g'; k < 'z'; k++)
				b.cheie += k+"";
			for(int i = 0; i < 5; i++)
				b.date[i] = (char)i;
			
			for(char k = 'k'; k < 'z'; k++)
				c.cheie += k+"";
			for(int i = 0; i < 5; i++)
				c.date[i] = (char)i;
			
			for(char k = 'l'; k < 'z'; k++)
				d.cheie += k+"";
			for(int i = 0; i < 5; i++)
				d.date[i] = (char)i;
			
		lista.insert(a, 3);
		lista.insert(b, 3);
		lista.insert(c, 3);
		lista.insert(d, 3);		*/
		
		System.out.println("+++"+dict.toString());
		
	    
	    
	    /*	System.out.print(a.cheie+": ");
			for(int k = 0; k < 5; k++)
	    		System.out.print(a.date[k]);
	    	System.out.println();
	    	
	    	System.out.println(lista.toString());*/
	    
	    	
		//a[0].cheie = Integer.toString(5);
	//	System.out.println(a.cheie);
		//for(int i = 0; i < 5; i++)
			//System.out.println(a.date[i]);
	}
}