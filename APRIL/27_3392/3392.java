//Approach 1-Brute Force-O(n)
class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<=n-3;i++)
        {
                if((nums[i]+nums[i+2])*2==nums[i+1])
                count++;
        }
        return count;
    }
}