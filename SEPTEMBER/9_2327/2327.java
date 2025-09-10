//Approach 1-Recursion + Memorization-O(n*(forget-delay)
class Solution {
    int mod=1_000_000_007;
    Integer[] dp;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int res=0;
        dp=new Integer[n+1];
        for(int day=n-forget+1;day<=n;day++)
        {
            if(day>0)
            {
                res=(res+solve(day,forget,delay))%mod;
            }
        }
        return res;
    }
    public int solve(int day,int forget,int delay)
    {
        if(day==1)
        return 1;
        if(dp[day]!=null)
        return dp[day];
        int res=0;
        for(int d=day-forget+1;d<=day-delay;d++)
        {
            if(d>0)
            {
                res=(res+solve(d,forget,delay))%mod;
            }
        }
        return dp[day]=res;
    }
}
//Approach 2-Bottom up
//O(n*(forget-delay))
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod=1_000_000_007;
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int d=2;d<=n;d++)
        {
            int count=0;
            for(int day=d-forget+1;day<=d-delay;day++)
            {
                if(day>0)
                count=(count+dp[day])%mod;
            }
            dp[d]=count;
        }
        int res=0;
        for(int day=n-forget+1;day<=n;day++)
        {
           if(day>0)
           res=(res+dp[day])%mod;
        }
        return res;
    }
}