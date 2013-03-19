import java.util.*;

public class Task2 implements Task 
{
        private int i;

        public Task2()
        {
            Random rand = new Random();
            i = rand.nextInt();
        }
        
        public void execute() throws Exception
        {
        	try{
        		if(i < 0)
        			throw new Exception();
        		System.out.println("Number: "+i);
        	} catch (Exception e)
        	{
        		System.out.println("Err: "+e.getMessage());
        	}
        }
}
