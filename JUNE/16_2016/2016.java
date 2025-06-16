//Approach 1-Brute Force-O(n^2)
class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int max=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            { 
                if((nums[j]-nums[i])>0)//nums[j]>nums[i]
                max=Math.max(max,nums[j]-nums[i]);
            }
        }
        return max;
    }
}
//Approach 2-Optimal-O(n)
class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int max=-1;
        int minTillNow=nums[0];
        for(int i=1;i<n;i++)
        {
            int currMax=nums[i]-minTillNow;
            minTillNow=Math.min(minTillNow,nums[i]);
            max=Math.max(max,currMax);
        }
        return max==0?-1:max;
    }
}