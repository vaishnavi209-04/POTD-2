//Approach 1-O(m * n)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int count=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i>0)//sum from (0,0) to (i-1,j)
                grid[i][j]+=grid[i-1][j];
                if(j>0)//sum from (0,0) to (i,j-1)
                grid[i][j]+=grid[i][j-1];
                if(i>0 && j>0)//remove the sum which was added twice from (0,0) to (i-1,j-1)
                grid[i][j]-=grid[i-1][j-1];

                if(grid[i][j]<=k)
                count++;
                else
                break;
            }
        }
        return count;
    }
}