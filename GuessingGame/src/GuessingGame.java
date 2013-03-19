import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
	public static void main(String[] args) 
	{
		Random rand = new Random();
		int numberToGuess = rand.nextInt(1000);
		int numberOfTries = 0;
		Scanner input = new Scanner(System.in);
		int guess;
		
		System.out.println("Guess a number between 0 and 1000: ");
		
		
		for(;;)
		{
			guess = input.nextInt();
			
			if(guess == numberToGuess)
			{
				System.out.println("Well done, the number is corect!\n");
				numberOfTries++;
				break;
			}
			else if(guess < numberToGuess)
					System.out.println("To low");
			else 	System.out.println("To high");
			
			numberOfTries++;
		}
		
		System.out.println("You won!");
		System.out.println("The number was " + guess);
		System.out.println("I took you " + numberOfTries + " tries");
	}
}
