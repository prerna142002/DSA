import java.util.*;
public class main {
	
    public static void main (String args[]) {
       Scanner sc = new Scanner(System.in);
       
       if( sc.hasNext() )
       {
    	   int t = sc.nextInt();
    	   while(t-->0)
    	   {
    		   int n = sc.nextInt();
    		   if(n == 1) System.out.println("-1");
    		   else
    		   {
    			   String ans = "2";
    			   for(int i=0;i<(n-1);i++) ans+="3";
    			   System.out.println(ans);
    		   }
    		   
    	   }
    	   
       }
       

       
    }
}
