//Approach 1-O(n)
class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int res=0;
        int xor=0;
        boolean allZero=true;
        for(int num:nums)
        {
            xor^=num;
            if(num!=0)
            allZero=false;

        }
        if(xor>0)
        return n;

        return allZero?0:n-1;
        
    }
}