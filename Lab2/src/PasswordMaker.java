
public class PasswordMaker
{
	/*2p) Sa se implementeze o clasa PasswordMaker ce genereaza o parola pornind de la datele unei persoane. 
	 * Aceasta clasa o sa contina urmatoarele:

    o constanta MAGIC_NUMBER avand orice valoare doriti
    un constructor care primeste: un String numit firstName, un String numit lastName si un int numit age
    o metoda getPassword() care va returna parola 

    Parola se construieste concatenand urmatoarele siruri: sirul format din ultimele (age % 3) litere din firstName, 
    un sir random de lungime MAGIC_NUMBER (folositi RandomStringGenerator si ce alfabet doriti) si sirul format prin 
    conversia la String a numarului (age + lungimea lui lastName). 
    Pentru subsiruri consultati documentatia clasei String */
	
	static int MAGIC_NUMBER;
	String firstName, lastName;
	int age;
	
	public PasswordMaker(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getPassword()
	{
		char[] a = firstName.toCharArray();
		char[] b = new char[age%3];
		String c;
		for(int i = 0; i < age%3; i++)
		{
			b[i] = a[i];
		}
		
		RandomStringGenerator mygenerator = new RandomStringGenerator(MAGIC_NUMBER, "abcdef");
		String d = new String();
		d = RandomStringGenerator.next();
		
	}
	
	

}
