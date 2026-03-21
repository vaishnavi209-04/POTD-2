//Approach 1-Brute Force-O(k^2)
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i1=x,i2=x+k-1;i1<i2;i1++,i2--)
        {
            for(int j=y;j<y+k;j++)
            {
                int temp=grid[i1][j];
                grid[i1][j]=grid[i2][j];
                grid[i2][j]=temp;
            }
        }
        return grid;
    }
}