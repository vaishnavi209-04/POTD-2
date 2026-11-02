//Approach 1-O(n)-Sorting + Median
class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int median=nums[n/2];
        int count=0;
        for(int num:nums)
        {
            count+=Math.abs(num-median);
        }
        return count;
    }
}