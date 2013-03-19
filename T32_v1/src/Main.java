import java.io.*;

/**Clasa Main;
 * 
 * @author ndr;
 */
public class Main 
{
	//@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Node n = new Node("", 0, 0); 
        
		n.parseTree(args[0]);
		PrintStream ps = System.out;	//retin referinta spre consola pt uz ulterior;
        
		//ParseTree
		try
		{
			PrintStream out = new PrintStream(new FileOutputStream(args[0]+"_pt"));
			System.setOut(out);	//hijacking the stOut; 
			n.print(n, 0);
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//SemanticVisitor
		SemanticVisitor sv = new SemanticVisitor();
		try
		{
			PrintStream out2 = new PrintStream(new FileOutputStream(args[0]+"_sv"));
			System.setOut(out2);	
			for(Node n1 : n.refCopii)
				n1.accept(sv);
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		//ResultVisitor 
		/*ResultVisitor rv = new ResultVisitor();
		if(!sv.dataStruct.containsKey(null) || !sv.dataStruct.containsValue("null"))
		{
			try
			{
				PrintStream out3 = new PrintStream(new FileOutputStream(args[0]+"_rv"));
				System.setOut(out3);
				
				for(Node n1 : n.refCopii)
					n1.accept(rv);
				rv.print();
			} catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}*/
		System.setOut(ps);
	}
}