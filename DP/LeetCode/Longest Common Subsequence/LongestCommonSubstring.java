class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        
        // int i = 0, j = 0, ans = 0, max = 0;
        int max = 0;
        int[][] dp  = new int[S1.length()+1][S2.length()+1];
        dp[0][0] = 0;
        for(int i=1;i<S1.length()+1;i++)
        {
            for(int j=1;j<S2.length()+1;j++ )
            {
                if( S1.charAt(i-1) == S2.charAt(j-1) )
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        
        for(int[] d: dp)
        {
            for(int i: d) max = Math.max(max,i);
        }
        
        return max;
        
    }
}
