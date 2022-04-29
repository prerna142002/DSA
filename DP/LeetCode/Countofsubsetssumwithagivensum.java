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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    int[][] dp;
    int func(int index, int[] arr, int sum, int val)
    {
        if(index >= arr.length)
        {
            if(sum == val) return 1;
            else return 0;
        }
        if(val>sum) return 0;
        if(dp[index][val] != -1) return dp[index][val];
        
        // if(sum == 0) return 1;
        dp[index][val] = ( (func(index+1,arr,sum,val)%1000000007) + 
                (func(index+1,arr,sum,val+arr[index])%1000000007))%1000000007;
        return dp[index][val];
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    dp = new int[n][sum+1];
	    for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
	    return func(0,arr, sum, 0);
	    
	} 
}
