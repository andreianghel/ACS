public class Task1 implements Task
{
        private String s;

        public Task1(String s)
        {
                this.s = s;
        }
        
        public void execute()
        {
                System.out.println(s);
        }
}
                                                           