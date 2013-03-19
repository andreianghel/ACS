public class Punct 
{
	private float x, y;

	public Punct(){}
	public Punct(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void changeCoords(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public void afis()
	{
		System.out.println("("+this.x+", "+this.y+")");
	}
}
