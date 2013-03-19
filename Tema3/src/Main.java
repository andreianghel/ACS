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
		Node tree = new Node(); 
        
		tree.parseTree(args[0]);
		PrintStream ps = System.out;	//retin referinta spre consola pt uz ulterior;
        
		//ParseTree
		try
		{
			System.setOut(new PrintStream(new FileOutputStream(args[0]+"_pt")));	//hijacking the stOut; 
			
			tree.print();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//SemanticVisitor
		SemanticVisitor sv = new SemanticVisitor();
		try
		{
			System.setOut(new PrintStream(new FileOutputStream(args[0]+"_sv")));	
			
			for(Node nod : tree.refCopii)
				nod.accept(sv);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//ResultVisitor 
		ResultVisitor rv = new ResultVisitor();
		if(!sv.dataStruct.containsKey(null) || !sv.dataStruct.containsValue("null"))	//daca fisierul are erori, nu se calculeaza;
		{
			try
			{
				System.setOut(new PrintStream(new FileOutputStream(args[0]+"_rv")));
				
				for(Node nod : tree.refCopii)
					nod.accept(rv);
				rv.print();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.setOut(ps);
	}
}