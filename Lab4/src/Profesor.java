public class Profesor extends Persoana
{
	private String materie;
	
	public Profesor(){}
	
	public Profesor(String nume, String materie)
	{
		super(nume);
		this.materie = materie;
	}
	
	public String toString()
	{
		return "Profesor: "+super.toString()+", "+this.materie+";";
	}
	
	public void preda()
	{
		System.out.println("Profesorul "+super.toString()+" preda.");
	}
	
}
