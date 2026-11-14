//Approach 1-Prefix Sum-O(n(r-l+1))
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=nums.get(i-1)+arr[i-1];
        }
        int min=Integer.MAX_VALUE;
        for(int i=l;i<=n;i++)
        {
            for(int j=Math.max(0,i-r);j<=i-l;j++)
            {
                int sum=arr[i]-arr[j];
                if(sum>0)
                min=Math.min(min,sum);
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}