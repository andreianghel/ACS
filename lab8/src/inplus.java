public class inplus
{
	public static class BugagaException extends Exception
	{}
	
   public static void main (String args[])throws Exception  
   {
      int n=20,result=0;
      try{
         result=n/0;
         System.out.println("The result is"+result);
      }
      catch(Exception ex){
         System.out.println("Arithmetic exception occoured: "+ex);
         try {
         throw new BugagaException();
         }
         catch(BugagaException ex1) {
            System.out.println("Chained exception thrown manually : "+ex1);
         }
      }
   }
}