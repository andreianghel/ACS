import java.util.ArrayList;

public class Boss extends Employee {
	float bonus;
	ArrayList<Employee> subordonati;

    public Boss(String name, float salary) {
            super(name, salary);
            bonus = 0;
    }
   
    public float getBonus() {
            return bonus;
    }

    public void setBonus(float bonus) {
            this.bonus = bonus;
    }
    
    public float getTotalRevenue() {
    	return salary + bonus;
    }
    
    @Override
	public void accept(Visitor v) {
		 v.visit(this);	
		 for(Employee e: this.subordonati)
			 e.accept(v);
	}

}
