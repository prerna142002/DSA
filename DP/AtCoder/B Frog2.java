import java.util.Arrays;
import java.util.*;

public class Main {
	static int[] dp;
	static int steps(int index ,int k, int[] heights)
	{
//		System.out.println("index "+index);
		if(dp[index] != -1) return dp[index];
		if(index >= heights.length-1) return 0;
		
		int z = steps(index+1,k,heights) + Math.abs( heights[index+1] - heights[index]);
		int min = z;
		
		for(int i=index+2;i<=(index+k);i++)
		{
			if( (i) < heights.length) 
			{
				z = steps(i,k,heights) + Math.abs( heights[index] - heights[i]);
				min = Math.min(min, z);
//				dp[index] = min;
				
			}
			
			else
				{
					dp[index] = min;
					return dp[index];
//					break;
				}
			
		}
		dp[index] = min;
		return dp[index];
		
	}

	public static void main(String[] args) {
//		Scanner sc = new
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		steps(0,k,a);
		if(dp[0] == -1) System.out.println(0);
		else System.out.println(dp[0]);

	}

}
