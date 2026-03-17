//Approach 1-Sorting -O(m * n * log n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int maxArea=0;

        for(int row=0;row<m;row++)//O(m)
        {
            for(int col=0;col<n;col++)//O(n)
            {
                if(matrix[row][col]==1 && row>0)
                matrix[row][col]+=matrix[row-1][col];//store cumulative consecutive 1s
            }
            int[] height=matrix[row].clone();//O(n)
            Arrays.sort(height);//O(log n) sort columns in ascending order of their height
            for(int i=0;i<n;i++)//O(n)
            {
                int base=n-i;//take all columns from i  
                int h=height[i];
                int area=base*h;
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}