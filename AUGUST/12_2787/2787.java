//Approach 1-dp + memorisation
//T.C-O(n^2)
class Solution {
    int mod=1_000_000_007;
    int[][] dp;
    public int numberOfWays(int n, int x) {
        dp=new int[301][301];//constraints- n<=300
        for(int[] arr:dp)
        Arrays.fill(arr,-1);
        return solve(n,1,x);
    }
    public int solve(int n,int num,int x)
    {
        if(n==0)
        return 1;
        if(n<0)
        return 0;
        int curr=(int) Math.pow(num,x);
        if(curr>n)
        return 0;
        if(dp[n][num]!=-1)
        return dp[n][num];
        int take=solve(n-curr,num+1,x);
        int skip=solve(n,num+1,x);
        return dp[n][num]=(take+skip)% mod;
    }
}