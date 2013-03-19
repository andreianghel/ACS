public class DelayTaskRunner extends PrintTaskRunner 
{
	int delay;
	
	public DelayTaskRunner(Strategy s, int delay)
	{
		super(s);
		this.delay = delay;
	}
	
	protected void actiune()
	{
		try{
			Thread.sleep(delay);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
