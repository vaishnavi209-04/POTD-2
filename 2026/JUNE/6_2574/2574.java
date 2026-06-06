//Approach 1-T.C=O(n) S.C=O(n)
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        left[0]=0;
        int[] right=new int[n];
        right[n-1]=0;
        int[] res=new int[n];

        for(int i=1;i<n;i++)
        {
            left[i]=left[i-1]+nums[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
            right[i]=right[i+1]+nums[i+1];
        }
        for(int i=0;i<n;i++)
        {
            res[i]=Math.abs(left[i]-right[i]);
        }
        return res;
    }
}
//Approach 2-T.C=O(n) S.C=O(1)
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        int[] res=new int[n];

        for(int num:nums)
        right+=num;

        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            right-=num;
            res[i]=Math.abs(left-right);
            left+=num;
        }
        return res;
    }
}