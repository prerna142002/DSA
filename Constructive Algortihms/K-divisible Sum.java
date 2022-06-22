import java.util.*;
public class main {
	
    public static void main (String args[]) {
       Scanner sc = new Scanner(System.in);
       
       if( sc.hasNext() )
       {
    	   int t = sc.nextInt();
    	   while(t-->0)
    	   {
    		   long n = sc.nextLong();
    		   long k = sc.nextLong();
    		   if( n<k )
    		   {
    			   if( k%n == 0 ) System.out.println( (k/n) );
    			   else System.out.println( ( (k/n) +1 )  );
    		   }
    		   else
    		   {
    			   if( n%k == 0 ) System.out.println("1");
    			   else
    			   {
    				   System.out.println("2");
    			   }
    		   }
    	   }
    	   
       }
       
 
       
    }
}
