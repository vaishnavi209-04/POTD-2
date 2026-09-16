//Approach 1:Optimal Dp- O(nk)
class Solution {
    public int numberOfSets(int n, int k) {
        int[][] dp=new int[n+1][k+1];
        int[] sum=new int[k+1];
        int mod=1_000_000_007;

        for(int i=0;i<=n;i++)
        {
           dp[i][0]=1;//1 way for 0 segments
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                sum[j]=(int)(sum[j]+(long)dp[i-1][j-1])%mod;
                //skip+take
                dp[i][j]=(int)(dp[i-1][j]+(long)sum[j])%mod;
            }
        }
        return dp[n][k];
    }
}