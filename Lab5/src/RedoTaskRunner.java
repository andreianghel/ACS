public class RedoTaskRunner extends AbstractTaskRunner
{
        Container container;
 
        public RedoTaskRunner(Strategy str)
        {
                super(str);
        }
        
        protected void actiune()
        {
        	container.push(t);
        }
        
        public void reexec()
        {
    		while (!container.isEmpty())
    		{
    			Task t = container.pop();
    			t.execute();
    		}
        }
}
