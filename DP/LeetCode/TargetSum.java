class Solution {
    
    HashMap<String,Integer> map;
    int func(int index,int[] a, int target, int val)
    {
        if(index >= a.length ) 
        {
            if(target == val) return 1;
            else return 0;
        }
        // if(val>target) return 0;
        String s = index+" "+val;
        if(map.containsKey(s)) return map.get(s);
        int sum = val;
        int z  = func(index+1,a,target,sum+a[index]) + func(index+1,a,target,sum-a[index]);
        map.put( s , z);
        return z;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        int a =  func(0, nums,target,0);
        // System.out.println(map);
        return a;
    }
}
