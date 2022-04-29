class Solution {
    public int combinationSum4(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int i=0;i<=amount;i++)
        {
            for(int j: coins)
            {
                if(  (i+j)<=amount) dp[i+j] += dp[i];
            }
        }
        
        return dp[amount];
    }
}
