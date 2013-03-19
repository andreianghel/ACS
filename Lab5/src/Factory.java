public class Factory implements IFactory
{
        public Container createContainer(Strategy strategy)
        {
                if(strategy == Strategy.FIFO)
                        {
                                Queue q = new Queue();
                                return q;
                        }
                
                else if(strategy == Strategy.LIFO)
                { 
                	Stack s = new Stack();
                    return s;
                }
                else return null;
        }
}

