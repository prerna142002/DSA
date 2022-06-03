public class Solution {

    int[][] dp;
    boolean func(int[] A, int B,int index, int val)
    {
        if(val>B) return false;
        if(val == B) return true;
        if(index >= A.length) return false;
        if(dp[index][val] != -1)
        {
            if(dp[index][val] == 1) return true;
            return false;
        } 
        boolean ans = func(A,B,index+1,val) || func(A,B,index+1,val+A[index]);
        if(ans) dp[index][val] = 1;
        else dp[index][val] = 0;
        return ans;
    }

    public int solve(int[] A, int B) {
        dp = new int[A.length][B+1];
        for(int i=0;i<A.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        boolean z = func(A,B,0,0);
        if(z) return 1;
        return 0;


    }
}
