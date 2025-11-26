//Approach 1-Recursion + Memoization
//T.C=(m*n*k)
class Solution {
    int m;
    int n;
    int mod=1_000_000_007;
    Integer[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        dp=new Integer[m][n][k];
        return solve(grid,k,0,0,0);
    }
    public int solve(int[][] grid,int k,int rem,int i,int j)
    {
        if(i<0 || j<0 || i>=m || j>=n)
        return 0;

        rem=(rem+grid[i][j])%k;

        if(dp[i][j][rem]!=null)
        return (dp[i][j][rem])%mod;

        
        int right=solve(grid,k,rem,i,j+1);
        int down=solve(grid,k,rem,i+1,j);
        if(i==m-1 && j==n-1)
        {
           return rem==0?1:0;
        }

        return dp[i][j][rem]=(right+down)%mod;
    }
}