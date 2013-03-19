public class LazyStudent extends Student
{
	/**Constructor pentru LazyStudent;
	 * 
	 * @param nume numele studentului;
	 * @param varsta varsta studentului;
	 */
	public LazyStudent(String nume, int varsta) 
	{
		super(nume, varsta);
	}

	/**Metoda ce calculeaza hashCode;
	 */
	@Override
	public int hashCode()
	{
		return 42; //the answer to the meaning of life, the universe, and everything;
	}
}
