/**
 * 
 * Clasa ce defineste tipul Element
 * 
 * @author Andrei
 *
 */
public class Element
{
	//clasa elementara: cheie + numere index
	public String cheie;
	public char[] date;


	public Element()
	{
		//this.cheie = "";
		this.date = new char[100];
		//initializare pt integer, pt a scapa de: Exception in thread "main" java.lang.NullPointerException
	}
}
