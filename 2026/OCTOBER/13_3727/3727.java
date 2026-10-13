//Approach 1-Greedy-Calculate squares and sort arr after storing them:O(n log n)
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[] arr=new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=nums[i]*nums[i];
        }
        Arrays.sort(arr);
        long res=0;
        for(int i=n-1;i>=n/2;i--)
        {
            res+=arr[i];
        }
        for(int i=n/2-1;i>=0;i--)
        {
            res-=arr[i];
        }
        return res;
    }
}