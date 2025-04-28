//Approach 1-Sliding Window-O(n)
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0;
        int j=0;
        int n=nums.length;
        long sum=0;
        long res=0;
        while(j<n)
        {
            sum+=nums[j];
            while((sum*(j-i+1))>=k)
            {
                sum-=nums[i];
                i++;
            }
            res+=(j-i+1);
            j++;
        }
        return res;
    }
}