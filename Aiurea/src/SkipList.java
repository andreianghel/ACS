import java.util.Random;

public class SkipList
{
	public class SkipListNode
	{
		public class Element
		{
			String cheie;
			char[] date;
		}
		
		Element e;
		SkipListNode[] next;
		int level;
		
		public SkipListNode(Element e, int level)
		{
			this.e = e;
			this.level = level;
		}
	}
  
  private SkipListNode head;   // Kopf der Liste
  private SkipListNode tail;   // Ende der Liste
  private int height;          // Aktuelle H"ohe der Liste
  public int maxHeight;        // Maximale bisherige H"ohe der Liste

  private SkipListNode[] update;
    

  public SkipList () {
    height = 0;
    maxHeight = 0;
    
    head = new SkipListNode (null, 0);
    tail = new SkipListNode (null, 0);
    
    head.next[0] = tail;

    update = new SkipListNode[height+1];
  }
  

  private int randHeight () {
	Random rand = new Random();
    int height = 0;
    while (rand.nextDouble() <= 0.5) {
      height++;
    }
    return height;
  }

  
  public SkipListNode search (String cheie) {
    /* liefert den Knoten p der Liste mit p.key = key, falls es ihn gibt,
       und  null sonst */ 
    SkipListNode p = head;
    for (int i = height; i >= 0; i--) {
      /* folge den Niveau-i Zeigern */
      while (p.next[i].e.cheie.compareTo(cheie) < 0) 
      { p = p.next[i]; }
    }

    /* p.key < key <= p.next[0].key */

    p = p.next[0];
    if (p.e.cheie == cheie && p != tail) return p;
    else return null;
  }

  public void insert(Element2 e) {
    /* f"ugt den Schl"ussel key in die Skip-Liste ein */
    
    SkipListNode p = head;
    for (int i = height; i >= 0; i--) {
      while (p.next[i].e.cheie.compareTo(e.cheie) < 0) 
      { p = p.next[i]; }
      update[i] = p;     
    }

    p = p.next[0];
    if (p.e.cheie.equals(e.cheie))  {
      System.out.println("Schluessel "+e.cheie+" bereits vorhanden.");
      return; // Sch"ussel bereits vorhanden
    }
    
    int newheight = randHeight ();
    if (newheight > maxHeight) {      
      /* neues Kopfelement schaffen */
      SkipListNode oldHead = head;
      head = new SkipListNode(null, newheight);
      for (int i = 0; i <= maxHeight; i++)
	head.next[i] = oldHead.next[i];
      for (int i = maxHeight+1; i <= newheight; i++)
	head.next[i] = tail;
      
      maxHeight = newheight;

      /* die oberen Zeiger von update[i] auf das neue Kopfelement setzen */
      for (int i = height; i >= 0 && update[i] == oldHead; i--)
	update[i] = head;

      /* neues Hilfsarray update schaffen */
      SkipListNode[] oldUpdate = update;
      update = new SkipListNode[newheight+1];
      for (int i = 0; i <= height; i++)
	update[i] = oldUpdate[i];
    }

    if (newheight > height) {     
      /* aktuelle H"ohe der Skip-Liste anpassen */
      for (int i = height + 1; i <= newheight; i++)
	update[i] = head;
      height = newheight;
    }	

    p = new SkipListNode (e, newheight);

    for (int i = 0; i <= newheight; i++) {
      /* f"uge p in Niveau i nach update[i] ein */
      p.next[i] = update[i].next[i];
      update[i].next[i] = p;
    }
  }

    public void print () {
    for (int i = height; i >= 0; i--) {
      SkipListNode p = head.next[i];
      SkipListNode q = head.next[0];
      while (p != tail) {
	if (q == p) {
	  System.out.print(p.e.cheie+" ");
	  p = p.next[i];
	}
        else System.out.print("   ");
	q = q.next[0];
      }
      System.out.println();       
    }
    System.out.println();
  }
}