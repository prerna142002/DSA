import java.util.*;
public class main {
	
    public static void main (String args[]) {
       Scanner sc = new Scanner(System.in);
       
       if( sc.hasNext() )
       {
    	   int n = sc.nextInt();
    	   long k = sc.nextLong();
    	   long[] a = new long[n];
    	   for(int i=0;i<n;i++) a[i] = sc.nextLong();

    	   long sum = 0, prev = 0;
    	   int i =1;
    	   for(;i<=n;i++)
    	   {
    		   sum+=i;
//    		   System.out.println(sum);
    		   if( sum >= k ) break;
    		   prev = sum;
    	   }
//    	   System.out.println("prev "+prev);
    	   if( i== n && sum<k ) System.out.println("-1");
    	   else 
    	   {
    		   int index = -1;
        	   while(prev < k )
        	   {
        		   prev++;
        		   index++;
        	   }
        	   if(index == -1 && prev == k) System.out.println(a[0]);
        	   else System.out.println(a[index]);
        		   
        	   
    	   }
//    	   System.out.println(prev);
    	   
    	       	   
       }
    }
}
