//Approach 1-Dp-O(n^3)
class Solution {
    Integer[][] dp;
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        dp=new Integer[n][n];
        return solve(0,n-1,values);
    }
    public int solve(int i,int j,int[] values)
    {
        if(j-i<2)
        return 0;
        if(dp[i][j]!=null)
        return dp[i][j];

        int res=(int)1e9;
        for(int k=i+1;k<j;k++)
        {
            res=Math.min(res,values[i]*values[j]*values[k] + solve(i,k,values)+ solve(k,j,values));
        }
        return dp[i][j]=res;
    }
}