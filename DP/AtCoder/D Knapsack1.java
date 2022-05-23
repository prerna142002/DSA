import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
public class Main {
	static long[][] dp;
	static long steps(int index,int[] wt, int[] val, int W)
	{
		if( W == 0 || index >= wt.length ) return 0;
		if(dp[index][W] != -1) return dp[index][W];
		long l = steps(index+1,wt,val,W);
		if( (W-wt[index]) >= 0 ) l = Math.max( l , steps(index+1,wt,val,W-wt[index])+val[index]);
		dp[index][W] = l;
//		System.out.println("index "+index+" W "+W+" " +dp[index][W]);
		return l;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int W = sc.nextInt();
		int[] wt = new int[n];
		int[] val = new int[n];
		for(int i=0;i<n;i++)
		{
			wt[i] = sc.nextInt();
			val[i] = sc.nextInt();
		}
		
		dp = new long[n][W+1];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				dp[i][j] = -1;
			}
		}
		
		steps(0,wt,val,W);
		if(dp[0][W] == -1) System.out.println(0);
		else System.out.println(dp[0][W]);

	}

}
