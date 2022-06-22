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
    		   int index = 1;
    		   int[][] mat = new int[n][n];
    		   if( n == 1) System.out.println("1");
    		   else if( n == 2 ) System.out.println("-1");
    		   else{
    			   for(int i=0;i<n;i++)
        		   {
        			   int j = (i%2);
        			   for(;j<n;j+=2)
        			   {
        				   mat[i][j] = index++;
        			   }
        		   }
        		   for(int i=0;i<n;i++)
        		   {
        			   int j = 0;
        			   if( (i&1) == 0 ) j = 1;
        			   for(;j<n;j+=2)
        			   {
        				   mat[i][j] = index++;
        			   }
        		   }
        		   for(int[] p: mat)
        		   {
        			   for(int k: p) System.out.print(k+" ");
        			   System.out.println();
        		   }
    			   
    		   }
    		   
    	   }
    	   
       }
       
 
       
    }
}
