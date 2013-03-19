public class Employee implements Visitable {

    String  name;
    float   salary;
   
    public Employee(String name, float salary) {
            this.name       = name;
            this.salary     = salary;
    }

    public String getName() {
            return name;
    }

    public float getSalary() {
            return salary;
    }
    
    public float getBonus()
    {return 0;}

	@Override
	public void accept(Visitor v) {
		 v.visit(this);	
	}
}
