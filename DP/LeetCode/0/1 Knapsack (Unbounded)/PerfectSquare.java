class Solution {
    int[] dp;
    int func(int sum)
    {
        if(sum == 0) return 0;
        if(dp[sum] != -1) return dp[sum];
        int max = Integer.MAX_VALUE;
        int z = (int) Math.sqrt(sum);
        for(int i=1;i<=z;i++)
        {
            if((sum - i*i)>=0) max = Math.min(max,1+func( sum-(i*i) ));
        }
        dp[sum] = max;
        return max;
    }
    
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(n);
        
    }
}
