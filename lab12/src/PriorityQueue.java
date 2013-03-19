import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<T extends Number>
{
    public ArrayList<T> list;
    public ArrayList<T> l1;

    public PriorityQueue() 
    {
        list = new ArrayList<T>();
        l1 = new ArrayList<T>();
    }

    public boolean isEmpty() 
    {
        return list.isEmpty();
    }

    public void insert(T obj)
    {
        if(list.isEmpty())
    		list.add(obj);
    	else
    	{
    		for(int i = 0; i < list.size(); i++)
    			if(list.get(i).doubleValue() > obj.doubleValue())
    			{
    				list.add(i, obj);
    				return;
    			}
    		list.add(obj);
    	}
    }
    		
    public T remove() 
    {
        return list.remove(list.size()-1);
    }
    
    public void met()
    {
    	Iterator<T> it = l1.iterator();
    	
    	while(it.hasNext())
    		insert(it.next());
    }
    
    
    public static void main(String[] args)
    {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	
    	pq.insert(new Integer(5));
    	pq.insert(new Integer(4));
    	pq.insert(new Integer(2));
    	pq.insert(new Integer(6));
    	pq.insert(new Integer(8));
    	
    	int d = pq.list.size();
    	for(int i = 0; i < d; i++)
    		System.out.println(pq.remove());
    	
    	pq.l1.add(new Integer(5));
    	pq.l1.add(new Integer(4));
    	pq.l1.add(new Integer(2));
    	pq.l1.add(new Integer(6));
    	pq.l1.add(new Integer(8));
    	d = pq.l1.size();
    	pq.met();
    	
    	System.out.println("-------");
    	d = pq.l1.size();
    	for(int i = 0; i < d; i++)
    		System.out.println(pq.remove());
    }
    
} 