import java.awt.font.NumericShaper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

/**
 * @author Pruna Alexandra Elena
 * 
 * 
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ParseTree tree = new ParseTree();
		
		Node r=new Node("r", 0, 0);
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line = br.readLine();
		int nline = 1;
		while (line != null) {
			r.kid.add(tree.Construction(line, nline));
			line = br.readLine();
			nline++;
			
		}

   	
 PrintWriter pw=null;
 pw=new PrintWriter(args[0]+"_pt1");
 r.display(r, pw, "");
 pw.close();

 
  pw=null;
  pw=new PrintWriter(args[0]+"_sv111111");

 
 SemanticVisitor sv=new SemanticVisitor();
 
// for (int i=0; i<r.kid.size(); i++)
 
 for (Node n: r.kid)	
 {
 n.accept(sv);

// sv.dictionary
 }
 for(String s : sv.dictionary.keySet())
	 System.out.println(s + " " + sv.dictionary.get(s));
 pw.close();
 
 
 
 
 
 
	}
}
