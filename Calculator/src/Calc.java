import java.util.Scanner;


public class Calc
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double a, b, c;
		int op = -1;
		System.out.println("Insert first number: ");
		a = scan.nextDouble();
		System.out.println("Insert second number: ");
		b = scan.nextDouble();
		
		System.out.println("Basic Calculator:\n0.adunare, 1.scadere, 2.inmultire, 3.impartire");
		System.out.println("Choose the operation number");
		op = scan.nextInt();
		c = 10;
		switch(op)
		{
		case 0: c = a + b;
		case 1: c = a - b;
		case 2: c = a * b;
		case 3: c = a / b;
		//default: System.out.println("Choose a number from 0 to 3;");
		}
		System.out.println("The result is: " + c);
	}
}
