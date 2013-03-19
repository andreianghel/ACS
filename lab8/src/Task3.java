public class Task3 implements Task
{
        private static int k;

        public void execute() throws Exception
        {
        	try{
        		if(k < 0)
        			throw new Exception();
        		k++;
                System.out.println(k);
        	} catch (Exception e)
        	{
        		System.out.println("Err");
        	}
        }
}
