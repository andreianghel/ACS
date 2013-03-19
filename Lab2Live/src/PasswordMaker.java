public class PasswordMaker 
{
	private final int MAGIC_NUMBER = 6;
	private String firstName, lastName;
	private int age;
	
	public PasswordMaker(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getPassword()
	{
		char[] a = new char[age%3];
		char[] b = firstName.toCharArray();
		for(int i = 0; i < age%3; i++)
		{
			a[i] = b[i];
		}
		RandomStringGenerator generator = new RandomStringGenerator(MAGIC_NUMBER, "abcdef");
		int j = age + this.lastName.length();
		String s = j + "";
		String s1 = new String(a);
		
		return s1+generator.next()+s;
	}
}
