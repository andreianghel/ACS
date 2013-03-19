public abstract class AbstractTaskRunner 
{
        private Strategy strategy;
        private Container container;
        private Factory factory;
        public Task t;

        public AbstractTaskRunner(Strategy str)
        {
                strategy = str;
                factory = new Factory();
                container = factory.createContainer(str);
        }
        
        public void addTask(Task task)
        {
                container.push(task);
        }
        
        public void executeAll()
        {
                Container c = factory.createContainer(strategy);
                c.transferFrom(container);
                Task t = c.pop();
                while(t != null)
                        {
                                t.execute();
                                actiune();
                                t = c.pop();
                        }
        }
        
        protected abstract void actiune();
}
