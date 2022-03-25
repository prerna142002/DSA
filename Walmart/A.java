// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        HashMap<Character,Integer> set = new HashMap<>();
        int max = 0,start = 0; 
        for(int i=0;i<s.length();i++)
        {
            char z = s.charAt(i);
            if(set.containsKey(z))
            {
                start = Math.max(start, set.get(z)+1 );
            }
            set.put(z,i);
            max = Math.max( max, (i-start+1) );
            
        }
        return max;
        
    }
}
