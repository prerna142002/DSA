class Solution {
    
    
	int[][] dp;
	int func(String s1, String s2, int i1,int i2)
	{
		if(i1>=s1.length() || i2>=s2.length()) return 0;
		
		if(dp[i1][i2] != -1) return dp[i1][i2]; 
		int a ;
		if(s1.charAt(i1) == s2.charAt(i2))  {
			a = 1+func(s1,s2,i1+1,i2+1);
	    }
		else a = Math.max( func(s1,s2,i1,i2+1) , func(s1,s2,i1+1,i2) );
        dp[i1][i2] = a;		
		return a;
		
	}
    
    public int longestCommonSubsequence(String S1, String S2) {
        dp = new int[S1.length()][S2.length()];
		for(int i=0;i<S1.length();i++) Arrays.fill(dp[i],-1);
		return func(S1,S2,0,0);
        
    }
}