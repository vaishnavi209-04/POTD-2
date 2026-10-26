class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        Set<String> visited =new HashSet<>();
        for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                    {
                        if(grid[i][j]>0 && !visited.contains(i+","+j))
                        {
                            long[] sum=new long[1];
                            dfs(i,j,grid,visited,sum);
                            if(sum[0]%k==0)
                                res++;
                        }
                    }
            }
        return res;
    }
    public void dfs(int i,int j,int[][] grid,Set<String> vis,long[] sum)
    {
        int m=grid.length;
        int n=grid[0].length;
        vis.add(i+","+j);
        sum[0]+=grid[i][j];
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d:dir)
            {
                int x=i+d[0];
                int y=j+d[1];
                String key= x+","+y;
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]>0 && !vis.contains(key))
                    dfs(x,y,grid,vis,sum);
            }
    }
}