import java.io.*;

public class DecriptStream extends FileInputStream
{
	public DecriptStream(File file) throws FileNotFoundException
	{
		super(file);
	}
	
	@Override
	public int read() throws IOException
	{
		return super.read()-5;
	}
}
