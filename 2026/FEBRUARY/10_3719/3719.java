//Approach 1-Brute Force-O(n^2)
class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> odd=new HashSet<>();
            Set<Integer> even=new HashSet<>();
            for(int j=i;j<n;j++)//make all subarrays starting from index i
            {
                if(nums[j]%2==0)
                even.add(nums[j]);
                else
                odd.add(nums[j]);
                if(even.size()==odd.size())
                res=Math.max(res,j-i+1);

            }
        }
        return res;
    }
}