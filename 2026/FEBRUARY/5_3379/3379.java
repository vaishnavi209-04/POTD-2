//Approach 1-O(n)
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
            {
                int a=Math.abs(nums[i]);
                int index;
                if(nums[i]>0)
                {
                    index=(i+a)%n;
                }
                else if(nums[i]<0)
                {
                    index=((i-a)%n+n)%n;
                }
                else
                    index=i;
                res[i]=nums[index];
            }
        return res;
    }
}