//Approach 1-Sliding Window-O(n)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=0;
        for(int num:nums)
        {
            max=Math.max(max,num);
        }
        int i=0;
        int j=0;
        int n=nums.length;
        int cnt=0;
        long res=0;
        while(j<n)
        {
            if(nums[j]==max)
            cnt++;
            while(cnt>=k)
            {
                if(nums[i]==max)
                cnt--;
                i++;
                res+=n-j;
            }
            j++;
        }
        return res;
    }
}