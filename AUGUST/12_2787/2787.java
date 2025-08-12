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
//Approach 2-bottom up dp
//T.C-O(n^2)
class Solution {
    int mod=1_000_000_007;
    public int numberOfWays(int n, int x) {
       long[] dp=new long[n+1];//no of ways to have sum s
       dp[0]=1;//sum 0 by taking nothing
       for(int i=1;(int)Math.pow(i,x)<=n;i++)
       {
        int num=(int)Math.pow(i,x);
        //if no of ways to make S(6)=2 and we have num=4 currently then no of ways to make S(10)=S(10-4)
        for(int s=n;s>=num;s--)
        {
            dp[s]+=dp[s-num];
        }
       }
       return (int)(dp[n] % mod);
    }
}