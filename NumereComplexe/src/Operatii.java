public class Operatii
{
		public static NumarComplex adunare(NumarComplex a, NumarComplex b)
		{	
			NumarComplex c = new NumarComplex();
			c.re = a.re + b.re;
			c.im = a.im + b.im;
			
			return c;
		}
		
		public static NumarComplex inmultire(NumarComplex a, NumarComplex b)
		{
			NumarComplex c = new NumarComplex();
			c.re = (a.re * b.re) - (a.im * b.im);
			c.im = (a.re * b.im) + (a.im * b.re);
			
			return c;
		}
}