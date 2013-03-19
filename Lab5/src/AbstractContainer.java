import java.util.ArrayList;

public abstract class AbstractContainer implements Container 
{
	ArrayList<Task> list = new ArrayList<Task>();
	
	@Override
	public void push(Task task) 
	{
		list.add(task);
		
	}

	@Override
	public int size() 
	{
		return list.size();
	}

	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}


}
