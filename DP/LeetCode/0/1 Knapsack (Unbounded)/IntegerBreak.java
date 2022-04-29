class Solution {
    int[] dp;
    int func(int index, int z)
    {
        // if(index == 2 ) return 2;
        if((index == 0))
        {
            if(z>1) return 1;
            else return 0;
        }
        // if(index == 0) return index;
        // if(index<0) return 0;
        if(dp[index] != -1) return dp[index];
        int max = 0;
        for(int i=1;i<=index;i++)
        {
            max = Math.max(max ,(i*func(index-i, z+1)) );
        }
        dp[index] = max;
        return max;
        
    }
    
    public int integerBreak(int n) {
            dp = new int[n+1];
            Arrays.fill(dp,-1);
            return func(n, 0);
    }
}
