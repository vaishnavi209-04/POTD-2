//Approach 1-DFS-O(mn)
class Solution {
    int m;
    int n;
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0 && !vis[i][j] && dfs(grid,i,j,vis))
                count++;
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid,int i,int j,boolean[][] vis)
    {
        if(i<0 || j<0 || i>=m || j>=n)
        return false;

        if(grid[i][j]==1 || vis[i][j])
        return true;

        boolean isClosed=true;
        vis[i][j]=true;
        for(int[] d:dir)
        {
            int i_=i+d[0];
            int j_=j+d[1];
            if(!dfs(grid,i_,j_,vis))
            isClosed=false;
        }
        return isClosed;
    }
}