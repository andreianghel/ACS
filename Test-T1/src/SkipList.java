import java.util.Random;

public class SkipList 
{
	public int lines;
	//public static final double prob = 0.5; //arunci o moneda: iese cap, "promovezi" celula la lista de nivel superior; if(cap) -> mai arunci o data;
	Random rand;
	public final Nod head = new Nod(lines, null);	//head nu se modifica, si are ca si cheie null, pt a nu conta la cautare;
	
	int level = 0;
	
	public void Insert(Element elem, int lines)
	{
		Nod nod = head;
		Nod[] aux = new Nod[lines+1]; //aux = vector de "pointeri din stanga" 
		//aux <- ultimul nod atins(existent) pe nivelul respectiv(se repeta pe toate nivelurile;
		
		
		for (int i = level; i >= 0; i--) 
        {
			while (nod.urm[i] != null) //elementele sunt sortate deja, se insereaza in ordine corecta, verific doar daca am ajuns la final, null
       	 	{
				nod = nod.urm[i];
       	 	}
       	 	aux[i] = nod; //retin adresa
        }
        nod = nod.urm[0]; //am revenit pe nivelul 0 unde se face inserarea
        
        if(nod != null || nod.elem.cheie == elem.cheie)
        	nod.elem = elem;	//daca cheia exista, ii actualizez valoarea;
        else
        {	/*generam un nivel aleator; daca este mai mare ca nivelul listei -> actualizam nivelul listei si 
        	 *	retinem in aux "pointerii din stanga" dintre nivelurile level+1 si l*/
        	
        	int l = rand.nextInt((int)(Math.log(lines)/Math.log(2)));
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
	 *merge pe acelasi nivel, pana cand urm cheie este mai mare decat cea cautata
	 *daca nu a ajuns pe nivelul 0, coboara un nivel si repeta cautarea de la nodul curent spre dreapta
	 *se opreste daca nivelul este 0 si urmatoarea cheie este mai mare decat cheia cautata
	 *
	 * @param elem
	 * @return vectorul de intregi ce reprezinta nr de aparitii sau null in caza de esec (cheia nu se gaseste in lista)
	 */
	public int[] search(Element elem)
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

        	
        	
        
		
		
		
		
		
}


