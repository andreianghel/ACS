import java.util.Random;

/**
 * 
 * Clasa ce defineste tipul SkipList
 * 
 * @author Andrei
 *
 */
public class SkipSet
{
	public int lines;
	//public static final double prob = 0.5; //arunci o moneda: iese cap, "promovezi" celula la lista de nivel superior; if(cap) -> mai arunci o data;
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
	public void insert(Element elem, int lines)
	{
		Nod nod = head; 
		Nod[] aux = new Nod[lines+1]; /*aux = vector de "pointeri din stanga"
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
        	
        	Integer l = new Integer(rand.nextInt((int)(Math.log(lines)/Math.log(2))));
        	/*pentru a selecta nivelul aleator, l primeste o valoare de max log2(n);
        	 *  nr maxim de niveluri de liste ce se pot crea; 
   		 	 *	l = nivelul pana la care se va duplica nodul de pe nivelul 0;*/
        	
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
	
	/**	
	 * functie ce cauta un element in lista
	 * 
	 *porneste de pe cel mai inalt nivel al listei;
	 *merge pe acelasi nivel, pana cand urm cheie este mai mare decat cea cautata;
	 *daca nu a ajuns pe nivelul 0, coboara un nivel si repeta cautarea de la nodul curent spre dreapta;
	 *se opreste daca nivelul este 0 si urmatoarea cheie este mai mare decat cheia cautata;
	 *
	 * @param elem - elementul cautat;
	 * @return vectorul de intregi ce reprezinta nr de aparitii sau null in caza de esec (cheia nu se gaseste in lista);
	 */
	public char[] search(Element elem)
	{
		Nod nod = head;
		
		for(int i = level; i >= 0; i--)
			while(nod.urm[i] != null && nod.urm[i].elem.cheie.compareTo(elem.cheie) < 0)
				nod = nod.urm[i];
		
		nod = nod.urm[0];
		
		if(nod != null && nod.elem.cheie.equals(elem.cheie))	//daca nu a ajuns la final sau a gasit elem
			return nod.elem.date;
		else return null;
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


	
	
	
	

 
     public static void main(String[] args) {
 
         SkipSet ss = new SkipSet();
         System.out.println(ss);
         Element a = new Element();
         Element b = new Element();
         Element c = new Element();
         Element d = new Element();
         Element e = new Element();
         
         a.cheie = "ddddd";
         b.cheie = "hdgfhh";
         c.cheie = "waaaaa";
         a.date[0] = 4;
         
 
         ss.insert(a, 3);
         ss.insert(b, 3);
         System.out.println("ceva");
         ss.insert(c, 3);
         ss.insert(d, 3);
         ss.insert(e, 3);
         System.out.println("ceva: "+ss.toString());
         
        
         }
     }
