//Approach 1:Sorting + Sliding Window
//T.C-O(n log n)
//we have to find min diff of k num 
//for min diff nums should be as close to each other as possible
//sort the array and check for k size window 
//calc min in the window and return the lowest min
class Solution {
    public int minimumDifference(int[] nums, int k) {
       Arrays.sort(nums);
       int n=nums.length;
       int left=0;
       int right=0;
       int min=Integer.MAX_VALUE;
       while(right<n)
       {
        if((right-left+1)==k)
        {
            min=Math.min(min,nums[right]-nums[left]);
            left++;
        }
        right++;
       }
       return min;
    }
}