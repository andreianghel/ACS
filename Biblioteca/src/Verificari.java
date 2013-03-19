public class Verificari{
	public static boolean dubluExemplar(Carte a, Carte b)	{	
		return a.equals(b);
	}
	
	public static Carte maiGroasa(Carte a, Carte b){
		if(a.numarPagini > b.numarPagini) return a;	
		else return b;
	}
}
