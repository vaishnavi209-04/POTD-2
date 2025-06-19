//Approach 1-Sorting + Greedy-O(n)
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count=1;//an index itself is also a subsequence
        int min=nums[0];//array is sorted
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]-min>k)//condition breaks
            {
                count++;//previous window was a satisfactory subsequence
                min=nums[i];//update start of new subsequence
            }
        }
        return count;
    }
}