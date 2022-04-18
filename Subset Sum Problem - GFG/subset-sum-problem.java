// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int[][] dp;
    static boolean func(int[] a, int val, int sum, int index)
    {
        if(index >= a.length) return val==sum;
        if(val>sum) return false;
        if( dp[index][val] != -1 )
        {
            if( dp[index][val] == 1 ) return true;
            else return false;
        }
        
        boolean z = (func(a,val,sum,index+1) || func(a,val+a[index],sum,index+1));
        if(z) dp[index][val] = 1;
        else dp[index][val] = 0;
        return z;
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        dp = new int[N][sum+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        return func(arr,0,sum,0);
    }
}