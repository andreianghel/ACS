public class Carte{
	String titlu;
	String autor;
	String editura;
	Integer numarPagini;
	
	public Carte(){}
	
	public Carte(String titlu, String autor, String editura, Integer numarPagini){
		this.titlu = titlu;
		this.autor = autor;
		this.editura = editura;
		this.numarPagini = numarPagini;
	}
	
	public boolean equals(Carte a)
	{
		return this.titlu.equals(a.titlu) && this.autor.equals(a.autor) && this.editura.equals(a.editura) && this.numarPagini == a.numarPagini;
	}
}
