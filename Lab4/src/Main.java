public class Main 
{
	public static void main(String[] args)
	{
		Profesor prof = new Profesor("Andru", "POO");
		Student stud = new Student("Andrei", 11);
		Student stud2 = new Student("Andrei", 11);
		Student stud3 = new Student("Ana", 7);
		
		System.out.println(prof.toString()+" "+stud.toString());
		
		Persoana[] vector = new Persoana[2];
		vector[0] = new Profesor("Kalisz", "PC");
		vector[1] = new Student("Urziceanu", 5);
		for(int i = 0; i < vector.length; i++)
		{
			System.out.println(vector[i].toString());
			if(vector[i] instanceof Profesor)
				((Profesor)vector[i]).preda();
			if(vector[i] instanceof Student)
				((Student)vector[i]).invata();
		}
		
		if(stud.equals(stud3)) System.out.println("este");
		else System.out.println("nu este");
		
		
			
		
	}

}
