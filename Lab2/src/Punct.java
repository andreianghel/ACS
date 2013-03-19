
public class Punct 
{
	/*(1p) Sa se implementeze o clasa Punct care sa contina:

    un constructor care sa primeasca cele doua numere reale (de tip float) ce reprezinta coordonatele.
    o metoda changeCoords ce primeste doua numere reale si modifica cele doua coordonate ale punctului.
    o functie de afisare a unui punct astfel: "(x, y)". */
	
	Float x, y;
	
	public Punct(){}
	public Punct(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void changeCoords(float x, float y)
	{	
		this.x = x;
		this.y = y;
	}
	
	public void afisare(Punct p)
	{
		System.out.printf("(%li, %li)", p.x, p.y);
		System.out.println("("+p.x+", "+p.y+")");
	}

}
