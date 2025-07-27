//Approach 1-O(n)
class Solution {
    public int countHillValley(int[] nums) {
        int n=nums.length;
        int count=0;
        int prev=0;
        for(int i=1;i<n-1;i++)
        {
            if((nums[prev]>nums[i] && nums[i]<nums[i+1]) || (nums[i]>nums[prev] && nums[i]>nums[i+1]))
            {
            count++;//valley or hill
            prev=i;
            }

        }
        return count;
    }
}