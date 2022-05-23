import java.util.*;
import java.io.*;

public class Main{
	static Double[][] dp;
	static double func(double[] a, int index, int count)
	{
		if(index == a.length) return 1;
		if( dp[index][count] != null) return dp[index][count];
//		double ans = 0;
		if(count<(a.length/2) ) dp[index][count] = (a[index]*( func(a,index+1,count) ) ) + ( (1-a[index]) * func(a,index+1,count+1) ) ;
		else dp[index][count] = a[index]*( func(a,index+1,count) );
		
		return dp[index][count];
		
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] a = new double[n];
		dp = new Double[n+1][(n/2) + 1];
		
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextDouble();
//			Arrays.fill(dp[i], -1);
		}
		
//		Recurssive
		System.out.println(func(a,0,0));
		
//		Tabulation
		
		
		
		
		sc.close();
	}

}

