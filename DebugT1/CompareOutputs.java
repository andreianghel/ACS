import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CompareOutputs {
	
	public static void main(String[] args) {
		try {
			Scanner reader1 = new Scanner(new File(args[0]));
			Scanner reader2 = new Scanner(new File(args[1]));

			char[] docs1, docs2;
			
			String lineR1, lineR2;
			
			while (reader1.hasNextLine()) {
				if (!reader2.hasNextLine()) {
					reader1.close();
					reader2.close();
					System.out.println("Sizes don't match");
					System.exit(1);
				}
				lineR1 = reader1.nextLine();
				lineR2 = reader2.nextLine();
				
				lineR1 = lineR1.replaceAll("\\s", "");
				lineR2 = lineR2.replaceAll("\\s", "");
				
				docs1 = lineR1.toCharArray();
				docs2 = lineR2.toCharArray();
				
				Arrays.sort(docs1);
				Arrays.sort(docs2);
				
				if (!Arrays.equals(docs1,docs2))
				{
					System.out.println("Docs don't match");
					System.exit(1);
				}
			}
			reader1.close();
			reader2.close();

			System.out.println("OK");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
