public class Main {

	public static void main(String[] args)
	{
		PrintTaskRunner t  = new PrintTaskRunner(Strategy.FIFO);
		t.actiune();
		
		DelayTaskRunner t1 = new DelayTaskRunner(Strategy.FIFO, 10000);
		t1.addTask(new Task1("."));
		
		t1.executeAll();
		
		t.actiune();
		
	}
}
