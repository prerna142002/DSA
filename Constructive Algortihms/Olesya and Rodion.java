import java.util.*;
public class main {
  
    public static void main (String args[]) {
       Scanner sc = new Scanner(System.in);
       
       if( sc.hasNext() )
       {
    	   int n = sc.nextInt();
    	   int t = sc.nextInt();
    	   String ans = "";
    	   if( t == 10 )
    	   {
    		   for(int i=0;i<n-1;i++) ans += 1;
    		   ans+=0;
    		   if( n == 1 && (t == 10) ) System.out.println("-1");
    		   else System.out.println(ans);
    	   }
    	   else
    	   {
    		   for(int i=0;i<n;i++) ans += t;
    		   System.out.println(ans);
    	   }
    	   
    	   
    	   
    	   
       }
       

       
    }
}
