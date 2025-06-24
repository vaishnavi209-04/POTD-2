//Approach 1-Brute Force-O(n^2)
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(nums[j]==key && Math.abs(i-j)<=k)
                {
                res.add(i);
                break;//we are checking for i if there is a key<=k distance near it if one found then add no need to calc for others
                }
            }
        }
        return res;
    }
}