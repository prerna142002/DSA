class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i: coins)
        {
            for(int j=0;j<=amount;j++)
            {
                if( (i+j)<=amount ) dp[j+i] += dp[j];
            }
        }
        
        return dp[amount];
        
    }
}
