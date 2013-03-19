import java.util.Random;
import java.util.StringTokenizer;

/**
 * Clasa ce defineste tipul SkipList;
 *
 * contine metode necesare: insert, search, AND, OR, exprCalc;
 * 
 * @author Andrei
 *
 */
public class SkipList2
{
    Random rand;
    public int contor = 0;
    public final Nod head = new Nod(24, null);	//nod unic, cheie null, sa nu conteze la cautare;
    public int level = 0;
  
      
    /**	
	 * Metoda ce cauta un element in lista;
	 * 
	 * Porneste de pe cel mai inalt nivel al listei;
	 * merge pe acelasi nivel, pana cand urm cheie este mai mare decat cea cautata;
	 * daca nu a ajuns pe nivelul 0, coboara un nivel si repeta cautarea de la nodul curent spre dreapta;
	 * se opreste daca atinge nivelul 0 si urmatoarea cheie este mai mare decat cheia cautata;
	 *
	 * @param s: cheia elementului cautat;
	 * @return vectorul de intregi ce reprezinta nr de aparitii sau null in caza de esec (cheia nu se gaseste in lista);
	 * @author Andrei;
	 */
	public Integer[] search(String s)
	{
		Nod nod = head;
		
		for(int i = level; i >= 0; i--)
			while(nod.urm[i] != null && nod.urm[i].elem.cheie.compareTo(s) < 0)
				nod = nod.urm[i];
		
		nod = nod.urm[0];
		
		if(nod != null && nod.elem.cheie.equals(s))
			return nod.elem.date;
		else return null;
	}
   
      
    /**
	 * Metoda ce insereaza un elem in lista;
	 * 
	 * Implementarea algoritmului propus de William Pugh, optimizat pt inserarea elementelor ce vor fi cautate in mod repetat;
	 
	 * @param elem: elementul de inserat;
	 * @param prioritate: == true, elementul se insereaza pana pe ultimul nivel si astfel poate accesat f usor;
	 * @author Andrei;
	 */  
    public void insert(Element elem, boolean prioritate)
    {
        rand = new Random();	
        Nod nod = head;	
        Nod[] aux = new Nod[25];	 /*aux = vector de "referinte din stanga"
		aux <- ultimul nod atins(existent) pe nivelul respectiv (se repeta pe toate nivelurile);*/
  
        for (int i = level; i >= 0; i--) 
        {
        	while (nod.urm[i] != null && nod.urm[i].elem.cheie.compareTo(elem.cheie) < 0)
        	{
        		nod = nod.urm[i];
        	}
        	aux[i] = nod; 
        }
        nod = nod.urm[0];
  
        if(nod == null || !nod.elem.cheie.equals(elem.cheie))
        {   /*generez un nivel aleator; daca este mai mare ca nivelul listei -> actualizez nivelul listei si 
        	 *	retin in aux "referintele din stanga" dintre nivelurile level+1 si l*/     
        	
         contor++;
         int l = 0;
         if(prioritate == false)
           while(rand.nextFloat() <= 0.5 & l < 25) l++;
         else l = 24;
        	  
         if (l > level) 
         {
        	  for (int i = level + 1; i <= l; i++) 
          	  {
          		  aux[i] = head;
           	  }
           	  level = l;
         }
             
         /*alocam spatiu pt noul nod si ii atribuim "referintele din dreapta" pe care le are aux*/
         Nod nod2 = new Nod(l, elem);
         for (int i = 0; i <= l; i++)
         {
           	 nod2.urm[i] = aux[i].urm[i];
           	 aux[i].urm[i] = nod2;
         }
        }
      }
    
    
    /**
     * Metoda ce realizeaza reuniunea elementelor a 2 vectori de int;
     * 
     * Elementele fiind ordine crescatoare, se face o singura parcurgere, comparandu-se in orice moment cei 2 int din vectori;
     * 
     * @param a: cheia elementului ce contine primul vector de int; 
     * @param b: cheia elementului ce contine celalalt vector de int;
     * 
     * @return rezultat: vector de int ce contine reuniunea elem;
     * @author Andrei;
     */
    public Integer[] OR(String a, String b)
    {
    	if(this.search(a) == null & this.search(b) == null) return null;
    	if(this.search(a) == null) return this.search(b);
    	if(this.search(b) == null) return this.search(a);
    	
    	int i = 0, j = 0, la = 0, lb = 0, c = 0;
    	
    	for(int i2 = 0; i2 < this.search(a).length; i2++)
    		if(this.search(a)[i2] != null) la++;
    	for(int i2 = 0; i2 < this.search(b).length; i2++)
    		if(this.search(b)[i2] != null) lb++;
    	
    	Integer[] rezultat = new Integer[la+lb];
    	
    	while(i < la || j < lb)		//parcurgerea vectorilor in paralel
    	{
    		if(i == la)
    		{
    			rezultat[c] = this.search(b)[j];
    			c++;
    			j++;
    			continue;
    		}
    		if(j == lb)
    		{
    			rezultat[c] = this.search(a)[i];
    			c++;
    			i++;
    			continue;
    		}
    		if(this.search(a)[i] == this.search(b)[j])
    		{
    			rezultat[c] = this.search(a)[i];
    			c++;
    			i++;
    			j++;
    			continue;
    		}
    		if(this.search(a)[i] < this.search(b)[j])
    		{
    			rezultat[c] = this.search(a)[i];
    			c++;
    			i++;
    			continue;
    		}
    		if(this.search(a)[i] > this.search(b)[j])
    		{
    			rezultat[c] = this.search(b)[j];
    			c++;
    			j++;
    			continue;
    		}
    	}
    	return rezultat;	
    }
    
    /**
     * Metoda ce realizeaza intersectia a 2 vectori de intregi;
     * 
     * Elementele fiind ordine crescatoare, se face o singura parcurgere, comparandu-se in orice moment cei 2 int din vectori;
     * 
     * @param a: cheia elementului ce contine primul vector de int; 
     * @param b: cheia elementului ce contine celalalt vector de int;
     * 
     * @return rezultat: vector de int ce contine intersectia elem;
     * @author Andrei;
     */
    public Integer[] AND(String a, String b)
    {
    	if(this.search(a) == null || this.search(b) == null) return null;
    	
    	int i = 0, j = 0, la = 0, lb = 0, c = 0;
    	
    	la = this.search(a).length-1;
    	lb = this.search(b).length-1;
    	
    	Integer[] rezultat = new Integer[Math.min(la+1, lb+1)];
    	
    	while(i != la+1 && j != lb+1)	//parcurgerea vectorilor in paralel
    	{
    		if(this.search(a)[i] == null | this.search(b)[j] == null) break;
    		
    		if(this.search(a)[i] == this.search(b)[j])
    		{
    			rezultat[c] = this.search(a)[i];
    			c++;
    			i++;
    			j++;
    			continue;
    		}
    		if(this.search(a)[i] < this.search(b)[j])
    		{
    			i++;
    			continue;
    		}
    		if(this.search(a)[i] > this.search(b)[j])
    		{
    			j++;
    			continue;
    		}
    	}
    	return rezultat;
    }
    
    /**
     * Metoda ce calculeaza o expresie;
     * 
     * Stringul-expresia este de tipul (a OP b) unde a si b sunt chei din dictionar;
     * 
     * @param expr: stringul ce contine expresia ce va fi evaluata si calculata;
     * @return un obiect de tip Element ce va avea ca si cheie stringul primit ca paramateru si ca vector de Integer rezultatul calcului;
     */
    public Element exprCalc(String expr)
	{
		Element a = new Element();
		a.cheie = expr.replaceAll(" ", "_");
		StringTokenizer st = new StringTokenizer(expr, " ");
		String s1, s2, s3;
		s1 = st.nextToken(); 	//expresia din stanga - cheie din dictionar;
		s2 = st.nextToken();	//operatorul: and sau or;
		s3 = st.nextToken();	//expresia din dreapta - cheie din dictionar;
		
		if(s2.equals("or"))
		{
			if(this.OR(s1, s3) == null) a.date = null;
			else
			{
				a.date = new Integer[this.OR(s1, s3).length];
				a.date = this.OR(s1, s3);
			}
			
			return a;
		}
		else if(s2.equals("and"))
		{
			if(this.AND(s1, s3) == null) a.date = null;
			else
			{
				a.date = new Integer[this.AND(s1, s3).length];
				a.date = this.AND(s1, s3);
			}
	
			return a;
		}	
		else return null;
	}
}
