
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
        
        // dp = new int[N];
        // Recurssion and Memoization
        
        // Arrays.fill(dp,-1);
        // boolean ans = func(a,0);
        // if(ans) return 1;
        // else return 0;
        
        // Greedy 
        for(int i=0;i<a.length;i++)
        {
            if(a[i] == 0) return 0;
            int last = i+a[i];
            for(int j=i+1;j<a.length;i++)
            {
                
            }
        }
        
    }
};
