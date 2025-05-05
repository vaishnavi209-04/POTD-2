//Apparoach 1-O(n)
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0;
        int minIdx=-1;
        int maxIdx=-1;
        int culpritIdx=-1;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<minK || nums[i]>maxK)
            culpritIdx=i;
            if(nums[i]==minK )
            minIdx=i;
            if(nums[i]==maxK)
            maxIdx=i;
            int smaller=Math.min(maxIdx,minIdx);//it can be possible that max is before min
            int temp=(smaller-culpritIdx);//if -ve then subarray invalid 
            res+=temp>0?temp:0;
        }
        return res;
    }
}