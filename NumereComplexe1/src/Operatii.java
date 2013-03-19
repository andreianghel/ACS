
public class Operatii {
	
	public static NumarComplex add(NumarComplex a, NumarComplex b)
	{
		NumarComplex c = new NumarComplex();
		c.re = a.re + b.re;
		c.im = a.im + b.im;
		
		return c;
		
	}

}
