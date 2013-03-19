import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintTaskRunner extends AbstractTaskRunner 
{
        public PrintTaskRunner(Strategy str)
        {
                super(str);
        }

        protected void actiune()
        {
            DateFormat d1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");    
        	Date d = new Date();
            System.out.println(d1.format(d));
        }
}
