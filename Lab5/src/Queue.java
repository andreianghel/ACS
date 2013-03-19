import java.util.ArrayList;

public class Queue extends AbstractContainer
{
        ArrayList<Task> list = new ArrayList<Task>();
        
        public Task pop()
        {
                Task t;
                if(list.isEmpty())
                        return null;
                t = list.get(0);
                list.remove(0);
                return t;
        }
        
        public void transferFrom(Container container)
        {
                Task t = container.pop();
                while(t != null)
                {
                        list.add(t);
                        t = container.pop();
                }
        }
}
