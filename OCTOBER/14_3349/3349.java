//Approach 1-O(n*k)
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        for(int i=0;i<=n-2*k;i++)
        {
            if(check(nums,i,i+k-1) && check(nums,i+k,i+2*k-1))
            return true;
        }
        return false;
    }
    public boolean check(List<Integer> nums,int start,int end)
    {
        for(int i=start;i<end;i++)
        {
            if(nums.get(i)>=nums.get(i+1))
            return false;
        }
        return true;
    }
}