//Approach 1-recursion + memoization----TLE
//T.C=O(m*n*k*m*n)
//S.C=O(m*n*k)
class Solution {
    Integer[][][] dp;
    int m,n;
    public int minCost(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        dp=new Integer[m][n][k+1];
        return solve(0,0,k,grid);
    }
    public int solve(int i,int j,int k,int[][] grid)
    {
        if(i==m-1 && j==n-1)
        return 0;

        if(dp[i][j][k]!=null)
        return dp[i][j][k];

        int res=Integer.MAX_VALUE;
        //right
        if(j+1<n)
        {
            int next=solve(i,j+1,k,grid);
            res=Math.min(res,next+grid[i][j+1]);
        }
        //down
        if(i+1<m)
        {
            int next=solve(i+1,j,k,grid);
            res=Math.min(res,next+grid[i+1][j]);
        }
        //teleport
        if(k>0)
        {
            for(int x=0;x<m;x++)
            {
                for(int y=0;y<n;y++)
                {
                    if((x!=i || y!=j) && grid[x][y]<=grid[i][j])
                    res=Math.min(res,solve(x,y,k-1,grid));
                }
            }
        }
        return dp[i][j][k]=res;

    }
}
//Approach 2-Dp on grid-O(m*n*k*m*n)
class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        
        //for t=0 to t=k
        //base case dp[m-1][n-1][t]=0;

        for(int t=k;t>=0;t--)
        {
            for (int i = m-1; i >= 0; i--)
            {
                for (int j = n-1; j >= 0; j--)
                {
                    if(i==m-1 && j==n-1)
                    continue;
                    
                    int res = Integer.MAX_VALUE;
                    if (j + 1 < n) 
                    {
                        res = Math.min(res, dp[i][j + 1][t] + grid[i][j + 1]);
                    }

                    if (i + 1 < m)
                    {
                        res = Math.min(res,dp[i+1][j][t]+ grid[i + 1][j]);
                    }
                    
                    if (t<k) 
                    {
                        for (int x = 0; x < m; x++) 
                        {
                            for (int y = 0; y < n; y++) 
                            {
                                if ((x != i || y != j) && grid[x][y] <= grid[i][j])
                                    res = Math.min(res, dp[x][y][t+1]);
                            }
                        }
                    }
                    dp[i][j][t]=res;
                }
            }
        }
        return dp[0][0][0];
    }
}
//Approach 3-Layered dp + Prefix Optimization-O(m*n*k)
class Solution {
    public int minCost(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        for(int[] row:dp)
        Arrays.fill(row,Integer.MAX_VALUE);

        dp[m-1][n-1]=0;
        int max=0;
        for(int[] row:grid)
        {
            for(int val:row)
            {
                max=Math.max(max,val);
            }
        }

        int[] tele=new int[max+1];
        Arrays.fill(tele,Integer.MAX_VALUE);

        for(int t=0;t<=k;t++)
        {
            for(int i=m-1;i>=0;i--)
            {
                for(int j=n-1;j>=0;j--)
                {
                   if (j+1<n && dp[i][j+1]!=Integer.MAX_VALUE) 
                        dp[i][j]= Math.min(dp[i][j], dp[i][j + 1] + grid[i][j + 1]);

                   if (i+1<m && dp[i+1][j]!=Integer.MAX_VALUE)
                        dp[i][j]= Math.min(dp[i][j],dp[i+1][j]+ grid[i + 1][j]);

                    if(t>0)
                    dp[i][j]=Math.min(dp[i][j],tele[grid[i][j]]);
                }
            }
            for (int i = 0; i < m; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    int val = grid[i][j];
                    tele[val] = Math.min(tele[val], dp[i][j]);
                }
            }

            // Prefix minimum
            for (int v = 1; v <= max; v++) {
                tele[v] = Math.min(tele[v], tele[v - 1]);
            }
        }
        return dp[0][0];
    }
}