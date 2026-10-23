//Approach 1-O(n)- Calculate & of all nums[i] which are not at their correct position
class Solution {
    public int sortPermutation(int[] nums) {
        int res=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==i)
            continue;
            res&=nums[i];
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}