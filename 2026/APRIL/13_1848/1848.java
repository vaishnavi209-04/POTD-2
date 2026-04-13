//Approach 1-Burte Force-O(n)
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int res=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            {
                res=Math.min(res,Math.abs(i-start));
            }
        }
        return res;
    }
}