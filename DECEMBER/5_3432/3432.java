//Approach 1-Prefix Sum-O(N)
class Solution {
    public int countPartitions(int[] nums) {
        int partitions=0;
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=nums[i]+prefix[i-1];
        }
        for(int i=1;i<n;i++)
        {
            int diff=(prefix[n-1]-prefix[i-1])-prefix[i-1];
            if(diff%2==0)
            partitions++;
        }
        return partitions;
    }
}