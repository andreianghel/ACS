public class Task1 implements Task
{
        private String s;

        public Task1(String s)
        {
                this.s = s;
        }
        
        public void execute() throws Exception
        {
        	try{
            	if(s == null)
            		throw new NullPointerException();
            	System.out.println(s);
        	} catch (Exception e)
        	{
        		System.out.println(s);
        		//System.out.println("NPE: "+e.getMessage());
        	}
        }
        
        
}
                                                           