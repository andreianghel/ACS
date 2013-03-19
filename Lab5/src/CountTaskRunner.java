public class CountTaskRunner extends AbstractTaskRunner
{
        public int k = 0;
        
        public CountTaskRunner(Strategy str)
        {
                super(str);
        }
        
        protected void actiune()
        {
                k++;
        }
}
