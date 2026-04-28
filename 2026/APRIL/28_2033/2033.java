//Approach 1-O(m*n)-Sorting + Median
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m=grid.length;
        int n=grid[0].length;
        int[] arr=new int[m*n];
        int i=0;
        for(int[] nums:grid)
        {
            for(int num:nums)
            {
                arr[i++]=num;
            }
        }
        Arrays.sort(arr);
        int median=arr[m*n/2];
        int count=0;
        for(int num:arr)
        {
            if((num-median)%x!=0)
            return -1;
            count+=Math.abs((num-median)/x);
        }
        return count;
    }
}