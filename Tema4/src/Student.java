public class Student 
{
	String nume;
	int varsta;
	
	/**Constructor pt Student;
	 * 
	 * @param nume numele studentului;
	 * @param varsta varsta studentului;
	 */
	public Student(String nume, int varsta)
	{
		this.nume = nume;
		this.varsta = varsta;
	}
	
	/**Metoda ce calculeaza hashCode;
	 */
	@Override
	public int hashCode()
	{
		return 37 * 17 * (this.nume.hashCode() + ((Integer)this.varsta).hashCode());
	}
	
	/**Metoda ce determina daca obiectul curent si cel primit ca paramtru sunt egale;
	 * 
	 */
	@Override
	public boolean equals(Object o)
	{
		boolean bool = false;
		if(o instanceof Student)
		{
			Student s = (Student)o;
			if(this.nume.equals(s.nume))
				if(this.varsta == s.varsta)
					bool = true;
		}
		return bool;
	}
}
