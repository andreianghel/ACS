import java.util.ArrayList;


public class Stack extends AbstractContainer
{
        private ArrayList<Task> list = new ArrayList<Task>();

        public Task pop()
        {
                Task t;
                if(list.isEmpty())
                        return null;
                t = list.get(list.size()-1);
                list.remove(list.size()-1);
        
                return t;
        }
   
        public void transferFrom(Container container)
        {
                Task t = container.pop();
                while(t != null)
                {
                        list.add(list.size()+container.size()-1, t);
                        t = container.pop();
                }
        }
}
