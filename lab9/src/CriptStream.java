import java.io.*;

public class CriptStream extends FileOutputStream
{
	public CriptStream(File file) throws FileNotFoundException 
	{
		super(file);
	}

	public void write(int b)//StackOverFlow daca folosesc CriptStream
	{
			write(b+5);
	}
}
