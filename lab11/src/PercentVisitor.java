public class PercentVisitor implements Visitor {
	@Override
    public void visit(Employee e) {
			System.out.println("e: 0");
    }
	
	/*@Override
    public void visit(Boss b) {
            System.out.println(b.getBonus()/(b.getSalary()+b.getBonus()));
    }*/
	
	
	int sum = 0;
	int n = 0;
	@Override
    public void visit(Boss b) {
		float f = 
				sum += (100*b.getBonus()/b.getTotalRevenue());
	    n++;
		
		/*for(Employee e : b.subordonati)
        {
        	if(e instanceof Boss) getPercentage((Boss)e);
        	else visit(e);
        }*/
		
		if(n!=0)
    		System.out.println("proc: "+getPercentage(b)+"%"); 
	}
	
	
	public float sumBonus(Boss b)
	{
		for(Employee e: b.subordonati)
			return this.sum+e.getTotal;
		return this.sum;
	}
	
	public float sumSalary(Boss b)
	
	
	public float getPercentage(Boss b)
	{
		return sum / n;
	}
	
	
	
  	
	
	

}
