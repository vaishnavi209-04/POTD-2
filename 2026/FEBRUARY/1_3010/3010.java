//Approach 1-O(n)
class Solution {
    public int minimumCost(int[] nums) {
        
        int min=Integer.MAX_VALUE;
        int secMin=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i]<min)
            {
                secMin=min;
                min=nums[i];
            }
            else if(nums[i]<secMin)
            {
                secMin=nums[i];
            }
        }
        return nums[0]+min+secMin;

    }
}