//Approach 1-O(N)
class Solution {
    public int minimumOperations(int[] nums) {
        int res=0;
        for(int num:nums)
        {
            res+=Math.min(3-num%3,num%3);
        }
        return res;
    }
}