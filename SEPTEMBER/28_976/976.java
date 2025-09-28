//Approach 1-Brute Force-O(n^3)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int res=0;
        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(nums[i]+nums[j]>nums[k])
                    {
                        res=Math.max(res,nums[i]+nums[j]+nums[k]);
                    }
                }
            }
        }
        return res;
    }
}
//Approach 2-Optimal-O(n log n)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=n-3;i>=0;i--)
        {
            if(nums[i]+nums[i+1]>nums[i+2])
            {
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }
}