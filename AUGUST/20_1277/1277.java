//Approach 1-Top Down +Memorisation
//O(n^2)
class Solution {
    int[][] dp;
    int m,n;
    public int countSquares(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp=new int[m][n];
        for(int[] arr:dp)
        Arrays.fill(arr,-1);
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                res+=solve(i,j,matrix);
            }
        }
        return res;
    }
    public int solve(int i,int j,int[][] matrix)
    {
        if(i>=m || j>=n)
        return 0;
        if(matrix[i][j]==0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        //check in 3 dirn for each cell
        int right=solve(i,j+1,matrix);
        int down=solve(i+1,j,matrix);
        int diag=solve(i+1,j+1,matrix);
        return dp[i][j]=1+Math.min(right,Math.min(down,diag));
    }
}
//Approach 2-Bottom up-O(n^2)
class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=matrix[i][j];
                }
                else if(matrix[i][j]==1)
                {
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
                res+=dp[i][j];
            }
        }
        return res;
    }
}