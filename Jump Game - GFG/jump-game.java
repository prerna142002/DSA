// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int[] dp;
    static boolean func(int[] a, int index)
    {
        if( index>=(a.length-1) ) return true;
        if( dp[index]!=-1 )
        {
            if(dp[index] == 1 ) return true;
            else return false;
        }
        
        if(a[index] == 0) return false;
        if( (a[index]+index) >= (a.length-1) ) return true;
        
        boolean flag = false;
        for(int i=index+1;i<=(index+a[index]);i++)
        {
            flag |=( func(a,i) );
        }
        if(flag)  dp[index] =1;
        else dp[index] =0;
        return flag;
        
    }
    
    static int canReach(int[] a, int N) {
        dp = new int[N];
        Arrays.fill(dp,-1);
        boolean ans = func(a,0);
        if(ans) return 1;
        else return 0;
    }
};