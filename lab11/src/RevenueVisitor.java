public class RevenueVisitor implements Visitor {
	 @Override
     public void visit(Employee e) {
             System.out.println("e: "+e.getName() + " " + e.getSalary());
     }

     /*@Override
     public void visit(Boss b) {
             System.out.println(b.getName() + " " + (b.getSalary() + b.getBonus()));
     }*/
	
	@Override
    public void visit(Boss b) {
            System.out.println("b: "+b.getName() + " " + (b.getSalary() + b.getBonus()));
    }
}
