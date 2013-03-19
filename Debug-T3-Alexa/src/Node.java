import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node implements Visitable{

	List<Node> kid = new ArrayList<Node>();
	String value;
	int column;
	int line;

	public Node(String val, int c, int l) {

		this.value = val;
		this.column = c;
		this.line = l;

	}

	
	public String toString() {
		String s ;
		s = this.value + " (";
		Iterator<Node> it = this.kid.iterator();

		while(it.hasNext()){
		s += it.next() + ",";

		}
		s = s +  ")";
		return s ;
		}
	
	
	
	public void display (Node result, PrintWriter pw, String s)
		{
		
		pw.println(s+result.value);
       
		for(Node n : result.kid)
		display(n, pw, s+"\t");
		}


	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}


	


	




}