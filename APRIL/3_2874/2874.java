//Approach 1-O(n)
//prefix max for i and suffix max for k and fix both 
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int[] suffix=new int[n];
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
        {
           prefix[i]=Math.max(prefix[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            suffix[i]=Math.max(suffix[i+1],nums[i]);
        }
        long res=0;
        for(int i=1;i<n-1;i++)
        {
            res=(long)Math.max((long)(prefix[i-1] -nums[i])*suffix[i+1],res);
        }
        return res;
    }
}