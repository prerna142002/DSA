import java.util.*;
public class Main {
	
	static int[] memo;
	public static int func(int[] h, int index)
	{
		if( index >= h.length ) return 0;
		if( memo[index] != -1  ) return memo[index];
		int ans = 0;
		if( index+1 < h.length ) ans = Math.abs(h[index]-h[index+1])+func(h,index+1);
		if( index+2 < h.length ) ans = Math.min( ans , Math.abs(h[index]-h[index+2])+func(h,index+2));
		memo[index] = ans;
		return ans;
	} 
	
    public static void main (String args[]) {
       Scanner sc = new Scanner(System.in);
       
       if(sc.hasNext())
       {
//    	   int t = sc.nextInt();
//    	   while(t-->0)
//    	   {
    		   int n = sc.nextInt();
    		   int[] a = new int[n];

    		   for(int i=0;i<n;i++) a[i] = sc.nextInt();
    		   memo = new int[n];
    		   Arrays.fill(memo, -1);
    		   System.out.println(func(a,0));
    		   
//    	   }
       }
    }
}
