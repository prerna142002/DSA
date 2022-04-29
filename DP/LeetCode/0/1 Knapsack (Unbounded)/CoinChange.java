class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) return 0;
        if(coins.length == 1 && amount%coins[0] == 0) return amount/coins[0];
        if(coins.length == 1) return -1;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i:coins)
        {
            if(i<=amount)
            {
                for(int j=0;j<dp.length;j++)
                {
                    if( ((i+j) <= amount) && (dp[j] != Integer.MAX_VALUE ) )
                    {
                        dp[j+i] = Math.min(dp[j+i],dp[j]+1);                 
                    }
                }
            }
            
            // for(int p:dp) System.out.print(p+" ");
            // System.out.println();
        }
        
        return (dp[amount] == Integer.MAX_VALUE) ? -1:dp[amount];
        
    }
}
