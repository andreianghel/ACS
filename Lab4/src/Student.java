public class Student extends Persoana 
{
	private int nota;
	
	public Student(){}
	
	public Student(String nume, int nota)
	{
		super(nume);
		this.nota = nota;
	}
	
	public String toString()
	{
		return "Student: "+super.toString()+", "+this.nota+";";
	}
	
	public boolean equals(Student b)
	{
		boolean test = false;
	
		if(this.toString().equals(b.toString()))
			if(this.nota == b.nota)
				test = true;
			
		return test;
	}
	
	public void invata()
	{
		System.out.println("Studentul "+super.toString()+" invata.");
	}
}
