import java.util.*;

public class Task2 implements Task 
{
        private int i;

        public Task2()
        {
                Random rand = new Random();
                i = rand.nextInt();
        }
        public void execute()
        {
                System.out.println(i);
        }
}
