//Approach 1:
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count=1;
        int maxCount=0;
        if(nums.length==1)
        return 1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
               count++;
            else
            count=1;
            maxCount=Math.max(maxCount,count);
        }
        count=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
               count++;
            else
           count=1;
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
//Approach 2
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        if(n==1)
        return 1;
        int count1=1;//for increasing subarray
        int count2=1;//for decreasing subarray
        int maxCount=0;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                count1++;
                count2=1;
            }
            else if(nums[i]>nums[i+1])
            {
                count2++;
                count1=1;
            }
            else
            {
                count1=1;
                count2=1;
            }
            maxCount=Math.max(maxCount,Math.max(count1,count2));
        }
        return maxCount;
    }
}