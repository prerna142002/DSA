class Solution {
    int[][] dp;
    boolean func(int index,int[] nums, int val, int x)
    {
        if(index >= nums.length) return ( 2*val == x) ;
        // System.out.println(" "+index+"  "+val);
        if(dp[index][val] != -1)
        {
            if(dp[index][val] == 1) return true;
            else return false;
            // return dp[index];
        }
        
        boolean z = func(index+1,nums,val,x) || func(index+1,nums,val+nums[index], x);
        // System.out.println(z+" "+index);
        if(z == true) dp[index][val] = 1;
        else dp[index][val] = 0;
        
        return z;
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i: nums) sum+=i;
        dp = new int[nums.length][sum+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        return func(0,nums,0,sum);
        // System.out.pr
    }
}