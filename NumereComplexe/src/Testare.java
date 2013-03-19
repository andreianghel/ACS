public class Testare
{
	public static void main(String[] args) 
	{   
		NumarComplex z = new NumarComplex();
		NumarComplex y = new NumarComplex();
		z.re = 2;
		z.im = 3;
		y.re = 1;
		y.im = 2;
		
		System.out.print("Re adunarii: " +Operatii.adunare(z,  y).re);
		System.out.println(", im adunarii:" +Operatii.adunare(z, y).im);
		System.out.print("Re inmultirii: " +Operatii.inmultire(z, y).re);
		System.out.println(", im inmultirii: " +Operatii.inmultire(z, y).im);
		
		//System.out.printf("Adunare: %lf + i* %lf", Operatii.adunare(z, y).re, Operatii.adunare(z, y).im);
	}
}
