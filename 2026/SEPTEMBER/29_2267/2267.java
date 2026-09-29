//Approach 1-Dp-O(m*n*(m+n))
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int len=m+n-1;//path length of any path
        if(len%2!=0)//balanced parenthesis string should be of even length
        return false;
        //valid parenthesis string
        if(grid[0][0]!='(' || grid[m-1][n-1]!=')')
        return false;

        boolean[][][] dp=new boolean[m][n][len+1];
        dp[0][0][1]=true;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                continue;

                char ch=grid[i][j];
                int change=(ch=='(')?1:-1;
                if(i>0)//check from top
                {
                    for(int bal=0;bal<=len;bal++)
                    {
                        if(!dp[i-1][j][bal])
                        continue;

                        int newbal=bal+change;
                        if(newbal>=0)
                        dp[i][j][newbal]=true;
                    }
                }
                if(j>0)//check from left
                {
                    for(int bal=0;bal<=len;bal++)
                    {
                        if(!dp[i][j-1][bal])
                        continue;

                        int newbal=bal+change;
                        if(newbal>=0)
                        dp[i][j][newbal]=true;
                    }
                }


            }
        }
        return dp[m-1][n-1][0];
    }
}