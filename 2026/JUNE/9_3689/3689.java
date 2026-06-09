//Approach 1-O(N)
//since we can reuse same subarray take whole array as a subarray 
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long res=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums)
        {
            max=Math.max(num,max);
            min=Math.min(min,num);
        }
        long val=max-min;
        res=k*val;
        return res;
    }
}