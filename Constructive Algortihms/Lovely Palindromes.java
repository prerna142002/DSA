import java.util.*;
public class main {
	
    public static void main (String args[]) {
       Scanner sc = new Scanner(System.in);
       
       if( sc.hasNext() )
       {
//    	   int t = sc.nextInt();
//    	   while(t-->0)
//    	   {
    		   String n = sc.next();
    		   StringBuffer ans = new StringBuffer();
    		   ans.append(n);
    		   StringBuffer rev = new StringBuffer();
    		   rev.append(n);
    		   rev.reverse();
    		   ans.append(rev);
    		   System.out.println(ans);
    	   }
    	   
//       }
       

       
    }
}
