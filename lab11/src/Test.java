import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

        public static void main(String[] args) {
            List<Employee> employees = new LinkedList<Employee>();
            Boss becali = new Boss("Becali", 1000), b1;
            Employee e1, e2;
           
            e1 = new Employee("Costel", 15);
            e2 = new Employee("Gigel", 20);
            b1 = new Boss("Gigi", 300);
            b1.setBonus(10);
            employees.add(e1);
            employees.add(e2);
            employees.add(becali);
            employees.add(b1);
            becali.setBonus(100);    
          
            becali.subordonati = new ArrayList<Employee>();
            becali.subordonati.add(b1);
            b1.subordonati = new ArrayList<Employee>();
            b1.subordonati.add(e1);
            b1.subordonati.add(e2);
            becali.subordonati.add(new Employee("Andru", 300));
            
            
            Visitor v = new RevenueVisitor();
            becali.accept(v);
            System.out.println("-------");
            v = new PercentVisitor();
            becali.accept(v);
            
        	
        	/*Visitor v = new RevenueVisitor();
            for (Employee e : employees)
                      e.accept(v);
            
            v = new PercentVisitor();
            for (Employee e : employees)
                      e.accept(v); */
        }
}