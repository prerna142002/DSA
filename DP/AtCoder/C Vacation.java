import java.util.Arrays;
import java.util.*;

import java.util.Scanner;

public class Main {
	
	static int[][] dp;
	static int steps(int index,int prevIndex, int[] a, int[] b, int[] c)
	{
		if(index >= a.length) return 0;
		if(index == a.length-1)
		{
			if(prevIndex == 0) return dp[index][prevIndex] = Math.max(b[index], c[index]);
			if(prevIndex == 1) return dp[index][prevIndex] = Math.max(a[index],c[index]);
			if(prevIndex == 2) return dp[index][prevIndex] = Math.max(a[index], b[index]);
		}
		if(dp[index][prevIndex] != -1) return dp[index][prevIndex];

		
		int t, i=0;
		if(prevIndex == 3)
		{
			t = Math.max(a[index]+steps(index+1,0,a,b,c),b[index]+steps(index+1,1,a,b,c) );
			t = Math.max(t,c[index]+steps(index+1,2,a,b,c) );
		}
		else if(prevIndex == 0)
		{
			t = Math.max(b[index]+steps(index+1,1,a,b,c),c[index]+steps(index+1,2,a,b,c)  );
		}
		else if(prevIndex == 1)
		{
			t = Math.max(a[index]+steps(index+1,0,a,b,c),c[index]+steps(index+1,2,a,b,c)  );
		}
		else
		{
			t = Math.max(b[index]+steps(index+1,1,a,b,c),a[index]+steps(index+1,0,a,b,c));
		}

		dp[index][prevIndex] = t;
//		path.remove(i);
//		System.out.println(i+" "+dp[index][prevIndex]);
		return dp[index][prevIndex];
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		dp = new int[n+1][4];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<4;j++)
			{
				dp[i][j] = -1;
			}
		}
		ArrayList<Integer> path = new ArrayList<>();
		steps(0,3,a,b,c);

		if(dp[0][3] == -1) System.out.println(0);
		else System.out.println(dp[0][3]);

	}

}
