//Approach 1:DP-O(m*n*1024)
class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //at max each cell can have 1024 xor values
        boolean[][][] dp=new boolean[m][n][1024];
        int[][] temp=grid;//to store value temporarily

        dp[0][0][grid[0][0]]=true;//first cell has xor equal to its value

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)//already know the value of first cell
                continue;

                int val=temp[i][j];

                if(i>0)
                {//move from upper cell
                    for(int x=0;x<1024;x++)
                    {
                        if(dp[i-1][j][x])
                        dp[i][j][x^val]=true;
                    }
                }
                if(j>0)
                {//move from left cell
                    for(int x=0;x<1024;x++)
                    {
                        if(dp[i][j-1][x])
                        dp[i][j][x^val]=true;
                    }
                }
            }
        }
        for(int x=0;x<1024;x++)
        {
            if(dp[m-1][n-1][x])
            return x;
        }
        return -1;
    }
}