public class ex4
{
	public static void metoda()
	{
		try{
			//throw new Exception();
			return;
		}
		catch(Exception e)
		{
			System.out.println("Err: "+e);
			return;
		}
		finally
		{
			System.out.println("ceva");
		}
	}
	
	public static void main(String[] args)
	{	metoda();  }
}
