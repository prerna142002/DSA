import java.util.*;

public class frog1 {

	static int[] dp; 
	public static int steps(int index, int[] heights)
	{
		if(index >= heights.length-1) return 0;
		if(dp[index] != -1) return dp[index];
		int one=0, two=0;
		
		one = steps(index+1,heights) + Math.abs(heights[index]-heights[index+1]);
		if(index+2 >=heights.length) {
			return dp[index] = one;
		}
		two = steps(index+2,heights) + Math.abs(heights[index]-heights[index+2]);
		
		
		dp[index] = Math.min(one, two);
//		System.out.println("index "+index);
//		for(int p: dp) System.out.print(p+" ");
//		System.out.println();
		return dp[index];
	}
	
	public static void main(String[] args) {
		
//		Scanner sc = new
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		steps(0,a);
		System.out.println(dp[0]);

	}

}
