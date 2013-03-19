import java.io.PrintWriter;
import java.util.Stack;

public class ParseTree {

	public static void afis(Node result, PrintWriter pw, String s)
	{
		pw.println(s+result.value);
		
		for(Node n : result.kid)
			afis(n, pw, s+"\t");
	}
	
	public Node Construction(String line, int nline) {

		Stack<Node> result = new Stack<Node>();
		Stack<Node> operator = new Stack<Node>();
		String[] words = line.split(" ");
		int ncolumn = -1;
		
		for (int i = 0; i < words.length; i++)
		{
			ncolumn += 2;
		
			switch ((int)(words[i]).charAt(0)) 
			{

			case 43: 
			{//+ in ascii
				OperatorPlus add = new OperatorPlus(words[i], ncolumn, nline);
				
				if(!operator.isEmpty())	
				while (operator.lastElement().value.equals("*")) 
				{
						operator.lastElement().kid.add(result.pop());
					    operator.lastElement().kid.add(0,result.pop());
					    result.push(operator.pop());
				}
				operator.push(add);
				continue;
			}
			case 42:
			{	//* in ascii
				OperatorInmultire and = new OperatorInmultire(words[i],	ncolumn, nline);
				
				operator.push(and);
				continue;
			}
			case 61: {	//= in ascii
				OperatorEgal equal = new OperatorEgal(words[i], ncolumn, nline);
				operator.push(equal);
				continue;
			}
			default: 
			{
					if ((int) words[i].charAt(0) >= 97 && (int) words[i].charAt(0) <= 122) 
					{
						Variabila var = new Variabila(words[i], ncolumn, nline);
						
						result.push(var);
						continue;
					}
					else
					{
						Valoare value = new Valoare(words[i], ncolumn, nline);
						result.push(value);
						continue;
					}
			}
	      }
		}
		while (result.size() > 1)
		{
			operator.lastElement().kid.add(result.pop());
			 operator.lastElement().kid.add(0,result.pop());
			 result.push(operator.pop());
		}
		return result.pop();
	}
}
