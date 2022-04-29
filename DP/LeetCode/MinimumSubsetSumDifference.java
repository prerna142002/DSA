//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dp;
    int func(int[] a, int index, int x1, int x2)
    {
        if(index>=a.length) return Math.abs(x1-x2);
        if( dp[index][x1] != -1 ) return dp[index][x1];
        int a1 = func(a,index+1,x1+a[index],x2);
        int a2 = func(a,index+1,x1,x2+a[index]);
        dp[index][x1] = Math.min(a1,a2);
        return dp[index][x1];
    }
	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i: arr) sum+=i;
	    dp = new int[n][sum];
	    for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
	    return func(arr,0,0,0);
	} 
}
